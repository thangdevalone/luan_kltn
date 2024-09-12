package com.apec.pos.enu;

public enum ErrorCode {
    SUCCESS("Thành công"),
    FAIL("Thất bại"),
    UNKNOWN_ERROR("Không tìm thấy lỗi!"),
    UNAUTHORIZED("Bạn không được phép truy cập"),
    NOT_FOUND("Không tìm thấy!"),
    BAD_REQUEST("Lỗi");

    private String description;

    ErrorCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
