package com.apec.pos.dto.RoomDto;

public class AddRoomRequest {

    private Integer userId;
    private Integer shipperId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }


}
