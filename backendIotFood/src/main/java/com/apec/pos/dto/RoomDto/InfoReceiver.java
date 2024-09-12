package com.apec.pos.dto.RoomDto;

public class InfoReceiver {

    private Integer id;
    private String username;
    private String accountName;
    private String imgAccount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getImgAccount() {
        return imgAccount;
    }

    public void setImgAccount(String imgAccount) {
        this.imgAccount = imgAccount;
    }
}
