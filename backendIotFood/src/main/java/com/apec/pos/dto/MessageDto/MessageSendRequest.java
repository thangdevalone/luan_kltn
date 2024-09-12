package com.apec.pos.dto.MessageDto;

public class MessageSendRequest {

    private Integer userId;
    private String content;
    private Integer roomId;


    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageSendRequest(Integer userId, String content) {
        super();
        this.userId = userId;
        this.content = content;
    }


}
