package com.friends.sickseek.user.domain.type;

import com.friends.sickseek.shared.property.EnumProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Authority implements EnumProperty {
    USER("일반 사용자"),
    ADMIN("어드민");

    private final String description;
}
