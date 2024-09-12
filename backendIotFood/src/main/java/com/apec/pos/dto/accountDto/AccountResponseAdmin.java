package com.apec.pos.dto.accountDto;

import java.util.List;

public class AccountResponseAdmin {

    private Long totalRow;
    private List<LoginResponDto> loginResponDtos;

    public Long getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Long totalRow) {
        this.totalRow = totalRow;
    }

    public List<LoginResponDto> getLoginResponDtos() {
        return loginResponDtos;
    }

    public void setLoginResponDtos(List<LoginResponDto> loginResponDtos) {
        this.loginResponDtos = loginResponDtos;
    }


}
