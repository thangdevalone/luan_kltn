package com.apec.pos.dto.otpDto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Data
@NoArgsConstructor
@Component
public class OtpMail {

    private String otp;
    private LocalDateTime timeEx;
    private String email;

    public void generateOTPandTimeEx(String email) {
        this.otp = new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
        this.timeEx=LocalDateTime.now().plus(120, ChronoUnit.SECONDS);
        this.email = email;
    }

    public boolean authenticateOtp(String otp){
            if (this.otp.contains(otp)&&this.timeEx.isAfter(LocalDateTime.now()))
            {
                return true;
            }
            return false;
    }
}
