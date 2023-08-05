package com.friends.sickseek.missing.service;

import com.friends.sickseek.missing.domain.type.MissingType;
import com.friends.sickseek.missing.presentation.dto.response.MissingSimpleResponse;
import com.friends.sickseek.missing.repository.MissingRepository;
import com.friends.sickseek.shared.annotation.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class QueryMissingListUseCase {

    private final MissingRepository missingRepository;

    public List<MissingSimpleResponse> execute(MissingType type) {
        return missingRepository.findByType(type)
                .stream()
                .map(MissingSimpleResponse::new)
                .toList();
    }
}
