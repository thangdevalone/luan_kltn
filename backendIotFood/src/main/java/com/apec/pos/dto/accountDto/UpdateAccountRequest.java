package com.apec.pos.dto.accountDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountRequest {
    private Integer id;
    private String accountName;
    private MultipartFile multipartFile;
    private String password;
    private String sdt;
}
