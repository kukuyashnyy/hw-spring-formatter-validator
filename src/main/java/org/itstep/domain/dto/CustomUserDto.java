package org.itstep.domain.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomUserDto {
    private String login;
    private String password;
    private String confirmPassword;

}
