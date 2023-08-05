package com.friends.sickseek.missing.presentation.dto.response;

import com.friends.sickseek.missing.domain.Missing;
import com.friends.sickseek.missing.domain.type.Gender;
import com.friends.sickseek.missing.domain.type.MissingType;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MissingResponse {

    private final String pictureUrl;
    private final String name;
    private final Integer age;
    private final Gender gender;
    private final Integer height;
    private final Integer weight;
    private final LocalDate missingDate;
    private final String missingPlace;
    private final String missingClothes;
    private final String specialNote;
    private final MissingType type;

    public MissingResponse(Missing missing) {
        this.pictureUrl = missing.getPictureUrl();
        this.name = missing.getName();
        this.age = missing.getAge();
        this.gender = missing.getGender();
        this.height = missing.getHeight();
        this.weight = missing.getWeight();
        this.missingDate = missing.getMissingDate();
        this.missingPlace = missing.getMissingPlace();
        this.missingClothes = missing.getMissingClothes();
        this.specialNote = missing.getSpecialNote();
        this.type = missing.getType();
    }
}
