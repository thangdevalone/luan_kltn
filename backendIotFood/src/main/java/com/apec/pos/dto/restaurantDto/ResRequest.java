package com.apec.pos.dto.restaurantDto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ResRequest {

    private Integer id;
    private String restaurantName;
    private String address;
    private Integer quantitySold;
    private Double distance;
    private String detail;
    private String timeStart;
    private String timeClose;
    private String phoneNumber;
    private MultipartFile imgRes;
}
