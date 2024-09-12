package com.apec.pos.service.serviceInterface;

import com.apec.pos.dto.accountDto.*;
import com.apec.pos.entity.AccountEntity;

import java.io.IOException;
import java.util.List;

public interface AccountInterface {

    public LoginResponDto login(LoginRequest loginRequest);

    public LoginResponDto register(RegisterRequest registerRequest);

    public AccountInfoDto getUserInfo(String token);

    public LoginResponDto addEmployee(RegisterRequest registerRequest);

    public AccountInfoDto updateAccountInfo(UpdateRequest updateRequest,String username) throws Exception;

    public AccountResponseAdmin paging(Integer pageSize, Integer pageIndex);

    public LoginResponDto updateEmployee(UpdateAccountRequest updateAccountRequest) throws IOException;

    public void deleteAccount();

    public ResponseEmployeePaging pagingEmployee(Integer pageSize, Integer pageIndex);
}
