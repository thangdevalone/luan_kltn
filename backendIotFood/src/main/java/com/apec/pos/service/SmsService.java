package com.apec.pos.service;

import java.text.DecimalFormat;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apec.pos.dto.otpDto.OtpRequestDto;
import com.apec.pos.dto.otpDto.OtpResponseDto;
import com.apec.pos.dto.otpDto.OtpStatusDto;
import com.apec.pos.dto.otpDto.OtpValidationRequestDto;
import com.apec.pos.unitl.TwilioConfig;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SmsService {

    @Autowired
    private TwilioConfig twilioConfig;

    Map<String, String> otpMap = new HashMap<>();

    public OtpResponseDto sendSMS(OtpRequestDto otpRequest) {
        OtpResponseDto otpResponseDto = null;
        try {

            PhoneNumber to = new PhoneNumber(otpRequest.getPhoneNumber());//to
            PhoneNumber from = new PhoneNumber(twilioConfig.getPhoneNumber()); // from
            System.out.println(twilioConfig.getPhoneNumber());
            System.out.println(otpRequest.getPhoneNumber());
            String otp = generateOTP();
            String otpMessage = " Địt cụ b Otp của bạn là " + otp;
            Message message = Message
                    .creator(to, from,
                            otpMessage)
                    .create();
            otpMap.put(otpRequest.getUsername(), otp);
            otpResponseDto = new OtpResponseDto(OtpStatusDto.DELIVERED, otpMessage);
        } catch (Exception e) {
            e.printStackTrace();
            otpResponseDto = new OtpResponseDto(OtpStatusDto.FAILED, e.getMessage());
        }
        return otpResponseDto;
    }

    public String validateOtp(OtpValidationRequestDto otpValidationRequest) {
        Set<String> keys = otpMap.keySet();
        String username = null;
        for (String key : keys)
            username = key;
        if (otpValidationRequest.getUsername().equals(username)) {
            otpMap.remove(username, otpValidationRequest.getOtpNumber());
            return "OTP is valid!";
        } else {
            return "OTP is invalid!";
        }
    }

    private String generateOTP() {
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }
}
