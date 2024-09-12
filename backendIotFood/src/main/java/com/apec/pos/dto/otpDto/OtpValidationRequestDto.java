package com.apec.pos.dto.otpDto;

public class OtpValidationRequestDto {
    private String username;
    private String otpNumber;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOtpNumber() {
        return otpNumber;
    }

    public void setOtpNumber(String otpNumber) {
        this.otpNumber = otpNumber;
    }


}
