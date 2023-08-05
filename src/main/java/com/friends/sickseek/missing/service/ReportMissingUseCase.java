package com.friends.sickseek.missing.service;

import com.friends.sickseek.missing.domain.Missing;
import com.friends.sickseek.missing.presentation.dto.request.ReportMissingRequest;
import com.friends.sickseek.missing.repository.MissingRepository;
import com.friends.sickseek.shared.annotation.UseCase;
import com.friends.sickseek.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class ReportMissingUseCase {

    private final MissingRepository missingRepository;

    public void execute(User user, ReportMissingRequest request) {
        missingRepository.save(
                Missing.builder()
                        .pictureUrl(request.getPictureUrl())
                        .name(request.getName())
                        .age(request.getAge())
                        .height(request.getHeight())
                        .weight(request.getWeight())
                        .missingDate(request.getMissingDate())
                        .missingPlace(request.getMissingPlace())
                        .missingClothes(request.getMissingClothes())
                        .specialNote(request.getSpecialNote())
                        .type(request.getType())
                        .user(user)
                        .build()
        );
    }
}
