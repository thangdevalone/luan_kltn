package com.apec.pos.dto.accountDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequest {
    private String password;
    private String newPassword;
    private String accountName;
    private MultipartFile img;
    private String sdt;
}
