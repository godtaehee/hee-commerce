package com.hcommerce.heecommerce.user.dto.request;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class UserSignUpRequestDto {

    private Long id;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String password;

    @NonNull
    private String mainAddress;

    @Nullable
    private String detailAddress;

    public UserSignUpRequestDto(@NonNull String phoneNumber, @NonNull String password, @NonNull String mainAddress) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.mainAddress = mainAddress;
    }
}