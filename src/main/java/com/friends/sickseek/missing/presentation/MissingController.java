package com.friends.sickseek.missing.presentation;

import com.friends.sickseek.missing.presentation.dto.request.ReportMissingRequest;
import com.friends.sickseek.missing.service.ReportMissingUseCase;
import com.friends.sickseek.shared.auth.AuthenticationPrincipal;
import com.friends.sickseek.user.domain.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MissingController {

    private final ReportMissingUseCase reportMissingUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void reportMissing(
            @AuthenticationPrincipal User user,
            @RequestBody @Valid ReportMissingRequest request
    ) {
        reportMissingUseCase.execute(user, request);
    }
}
