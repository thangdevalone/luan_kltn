package com.apec.pos.dto.accountDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MailAuth {
    private String otp;
    private String username;
}
