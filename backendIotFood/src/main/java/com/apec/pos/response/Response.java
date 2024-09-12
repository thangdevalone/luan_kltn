package com.apec.pos.response;

import java.io.Serializable;

import com.apec.pos.enu.ErrorCode;
import lombok.Data;


@Data
public class Response<T> implements Serializable {

    /**
     * Function có thành công hay không
     */
    private boolean status;
    /**
     * *
     * Mã trả về của function
     */
    private ErrorCode type;
    /**
     * Message thông báo từ function
     */
    private String message;
    /**
     * Dữ liệu trả về của function
     */
    private T data;
    /**
     * trả về username hiện tại
     */
    private String usernameSend;

    public Response() {
    }

    public Response(boolean status) {
        this.status = status;
    }

    public Response(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Response(boolean status, String message, ErrorCode code) {
        this.status = status;
        this.message = message;
        this.type = code;
    }

    public Response(boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Response(boolean status, String message, ErrorCode code, T data) {
        this.status = status;
        this.message = message;
        this.type = code;
        this.data = data;
    }
    public Response(boolean status, ErrorCode type, String message, T data, String usernameSend) {
        this.status = status;
        this.type = type;
        this.message = message;
        this.data = data;
        this.usernameSend = usernameSend;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorCode getType() {
        return type;
    }

    public void setType(ErrorCode type) {
        this.type = type;
    }


}

