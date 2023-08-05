package com.friends.sickseek.missing.presentation.dto.response;

import com.friends.sickseek.missing.domain.Missing;
import com.friends.sickseek.missing.domain.type.Gender;
import lombok.Getter;

@Getter
public class MissingSimpleResponse {

    private final Long id;
    private final String pictureUrl;
    private final String name;
    private final Gender gender;
    private final Integer age;
    private final String specialNote;

    public MissingSimpleResponse(Missing missing) {
        this.id = missing.getId();
        this.pictureUrl = missing.getPictureUrl();
        this.name = missing.getName();
        this.gender = missing.getGender();
        this.age = missing.getAge();
        this.specialNote = missing.getSpecialNote();
    }
}
