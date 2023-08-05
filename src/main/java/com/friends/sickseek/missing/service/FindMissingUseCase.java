package com.friends.sickseek.missing.service;

import com.friends.sickseek.missing.domain.Missing;
import com.friends.sickseek.missing.presentation.dto.response.MissingResponse;
import com.friends.sickseek.missing.presentation.dto.response.MissingSimpleResponse;
import com.friends.sickseek.missing.repository.MissingRepository;
import com.friends.sickseek.shared.annotation.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class FindMissingUseCase {

    private final MissingRepository missingRepository;

    public MissingSimpleResponse execute() {
        Missing missing = getRandomOne();
        return new MissingSimpleResponse(missing);
    }

    public Missing getRandomOne() {
        List<Missing> missingList = missingRepository.findAll();
        int randomIndex = (int) (Math.random() * missingList.size());
        return missingList.get(randomIndex);
    }
}
