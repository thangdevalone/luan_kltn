package com.apec.pos.dto.accountDto;

public class RegisterRequest {

    private Integer id;
    private String username;
    private String password;
    private String sdt;
    private String accountName;
    private String imgUser;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
        this.imgUser = imgUser;
    }

    public RegisterRequest(Integer id, String username, String password, String sdt, String accountName,
                           String imgUser) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.sdt = sdt;
        this.accountName = accountName;
        this.imgUser = imgUser;
    }


}
