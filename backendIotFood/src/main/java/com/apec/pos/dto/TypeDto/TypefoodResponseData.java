package com.apec.pos.dto.TypeDto;

import java.util.Date;

public class TypefoodResponseData {

    private Integer id;
    private Boolean status;
    private String nameType;
    private String imgType;
    private Date createAt;
    private String createBy;


    public TypefoodResponseData() {
        super();
    }

    public TypefoodResponseData(Integer id, Boolean status, String nameType, String imgType, Date createAt,
                                String createBy) {
        super();
        this.id = id;
        this.status = status;
        this.nameType = nameType;
        this.imgType = imgType;
        this.createAt = createAt;
        this.createBy = createBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }


}
