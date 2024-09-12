package com.apec.pos.dto.TypeDto;

import org.springframework.web.multipart.MultipartFile;

public class UpdateTypeRequest {

    private Integer id;
    private MultipartFile imgType;
    private String nameType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MultipartFile getImgType() {
        return imgType;
    }

    public void setImgType(MultipartFile imgType) {
        this.imgType = imgType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }


}
