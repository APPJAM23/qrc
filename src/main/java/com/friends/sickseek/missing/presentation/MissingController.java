package com.friends.sickseek.missing.presentation;

import com.friends.sickseek.missing.domain.type.MissingType;
import com.friends.sickseek.missing.presentation.dto.request.ReportMissingRequest;
import com.friends.sickseek.missing.presentation.dto.response.MissingResponse;
import com.friends.sickseek.missing.presentation.dto.response.MissingSimpleResponse;
import com.friends.sickseek.missing.service.QueryMissingListUseCase;
import com.friends.sickseek.missing.service.QueryMissingUseCase;
import com.friends.sickseek.missing.service.ReportMissingUseCase;
import com.friends.sickseek.shared.auth.AuthenticationPrincipal;
import com.friends.sickseek.shared.s3.UploadFileService;
import com.friends.sickseek.shared.s3.constants.FolderConstant;
import com.friends.sickseek.shared.s3.response.UploadResponse;
import com.friends.sickseek.user.domain.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/missing")
@RestController
public class MissingController {

    private final ReportMissingUseCase reportMissingUseCase;
    private final QueryMissingListUseCase queryMissingListUseCase;
    private final QueryMissingUseCase queryMissingUseCase;
    private final UploadFileService uploadFileService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void reportMissing(
            @AuthenticationPrincipal User user,
            @RequestBody @Valid ReportMissingRequest request
    ) {
        reportMissingUseCase.execute(user, request);
    }

    @GetMapping
    public List<MissingSimpleResponse> queryMissingList(
            @RequestParam(required = false) MissingType type
    ) {
        return queryMissingListUseCase.execute(type);
    }

    @GetMapping("/{missing-id}")
    public MissingResponse queryMissing(
            @PathVariable("missing-id") Long id
    ) {
        return queryMissingUseCase.execute(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UploadResponse uploadImage(
            @AuthenticationPrincipal User user,
            @RequestPart(value = "image") MultipartFile image
    ) {
        return uploadFileService.execute(image, FolderConstant.MISSING, UUID.randomUUID().toString());
    }
}
