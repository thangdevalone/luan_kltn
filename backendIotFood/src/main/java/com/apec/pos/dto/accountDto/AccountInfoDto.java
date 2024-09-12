package com.apec.pos.dto.accountDto;

import lombok.Data;

@Data
public class AccountInfoDto {
    private String accountName;
    private String sdt;
    private String username;
    private String img;
    private String email;

    public AccountInfoDto(String accountName, String sdt, String username) {
        super();
        this.accountName = accountName;
        this.sdt = sdt;
        this.username = username;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getsdt() {
        return sdt;
    }

    public void setsdt(String sdt) {
        this.sdt = sdt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
