package com.friends.sickseek.missing.service;

import com.friends.sickseek.missing.domain.Missing;
import com.friends.sickseek.missing.exception.MissingNotFoundException;
import com.friends.sickseek.missing.presentation.dto.response.MissingResponse;
import com.friends.sickseek.missing.repository.MissingRepository;
import com.friends.sickseek.shared.annotation.UseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class QueryMissingUseCase {

    private final MissingRepository missingRepository;

    public MissingResponse execute(Long id) {
        return new MissingResponse(getMissing(id));
    }

    public Missing getMissing(Long id) {
        return missingRepository.findById(id)
                .orElseThrow(MissingNotFoundException::new);
    }
}
