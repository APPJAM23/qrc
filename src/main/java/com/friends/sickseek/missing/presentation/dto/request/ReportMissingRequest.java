package com.friends.sickseek.missing.presentation.dto.request;

import com.friends.sickseek.missing.domain.type.Gender;
import com.friends.sickseek.missing.domain.type.MissingType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReportMissingRequest {

    @NotBlank
    @URL
    private String pictureUrl;

    @NotBlank
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    private Gender gender;

    @NotNull
    private Integer height;

    @NotNull
    private Integer weight;

    @NotNull
    private LocalDate missingDate;

    @NotBlank
    private String missingPlace;

    private String missingClothes;

    private String specialNote;

    @NotNull
    private MissingType type;
}
