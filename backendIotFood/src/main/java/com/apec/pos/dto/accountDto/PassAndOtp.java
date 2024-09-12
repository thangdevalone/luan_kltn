package com.apec.pos.dto.accountDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassAndOtp {
    private String otp;
    private String newPassword;
    private String username;
}
