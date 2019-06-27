package ru.xipho.riskhakov.intechtest.dto;

import ru.xipho.riskhakov.intechtest.validations.PasswordMatchConfirmation;
import ru.xipho.riskhakov.intechtest.validations.ValidPassword;

import javax.validation.constraints.NotNull;

@PasswordMatchConfirmation
public class UserDto {
    @NotNull
    private String username;
    @ValidPassword
    private String password;
    private String confirmPassword;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
