package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {
    @NotBlank(message = "Username is rquired")
    @Size(min = 3, message = "Min 3 character is required")
    private String name;

    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6,message = Min 6 character is required)
    private String password;

    @NotBlank(message = "About is required")
    private String about;
    @Size(min = 8,max = 12,message = "Invalid Phonenumber ")
    private String phoneNumber;

}
