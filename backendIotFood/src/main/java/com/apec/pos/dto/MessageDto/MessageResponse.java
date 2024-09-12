package com.apec.pos.dto.MessageDto;

import java.util.Date;

public class MessageResponse {

    private Integer id;
    private String content;
    private Integer sendId;
    private Integer roomId;
    private Date createAt;


    public MessageResponse() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public MessageResponse(Integer id, String content, Integer sendId, Integer roomId, Date createAt) {
        super();
        this.id = id;
        this.content = content;
        this.sendId = sendId;
        this.roomId = roomId;
        this.createAt = createAt;
    }


}
