package com.hcommerce.heecommerce.user;

import com.hcommerce.heecommerce.user.dto.request.UserSignUpRequestDto;
import com.hcommerce.heecommerce.user.dto.response.UserSignUpResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLIntegrityConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserCommandRepository userCommandRepository;

    @Mock
    private UserQueryRepository userQueryRepository;

    @InjectMocks
    private UserService userService;

    @Nested
    @DisplayName("Sign-Up")
    class SignUpMethods {
        @Test
        void Must_Return_Auto_Generated_Id_After_SignUp() {
            // given
            String loginId = "loginId";
            String phoneNumber = "01000000000";
            String password = "password";
            String mainAddress = "mainAddress";

            UserSignUpRequestDto userSignUpRequestDto = new UserSignUpRequestDto(loginId, phoneNumber, password, mainAddress);

            given(userCommandRepository.save(userSignUpRequestDto)).willReturn(1L);

            // when
            UserSignUpResponseDto userSignUpResponseDto = userService.signUp(userSignUpRequestDto);

            // then
            assertEquals(userSignUpResponseDto.getId(), 1L);
        }

        @Test
        void Phone_Number_Have_To_Be_Unique() {
            // given
            String loginId = "loginId";
            String phoneNumber = "01000000000";
            String password = "password";
            String mainAddress = "mainAddress";

            UserSignUpRequestDto userSignUpRequestDto = new UserSignUpRequestDto(loginId, phoneNumber, password, mainAddress);

            given(userQueryRepository.findByPhoneNumber(userSignUpRequestDto.getPhoneNumber())).willReturn(phoneNumber).willThrow();

            // when
            // then
            assertThrows(RuntimeException.class, () -> {
                userService.signUp(userSignUpRequestDto);
            });
        }
    }




}