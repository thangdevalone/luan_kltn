package com.apec.pos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class MessageEntity extends BaseEntity {

    @Column
    private String content;

    @Column(name = "accountEntityId")
    private Integer accountEntityId;

    @Column(name = "roomChatEntityId")
    private Integer roomChatEntityId;

    public Integer getAccountEntityId() {
        return accountEntityId;
    }

    public void setAccountEntityId(Integer accountEntityId) {
        this.accountEntityId = accountEntityId;
    }

    public Integer getRoomChatEntityId() {
        return roomChatEntityId;
    }

    public void setRoomChatEntityId(Integer roomChatEntityId) {
        this.roomChatEntityId = roomChatEntityId;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public RoomChatEntity getRoomChatEntity() {
        return roomChatEntity;
    }

    public void setRoomChatEntity(RoomChatEntity roomChatEntity) {
        this.roomChatEntity = roomChatEntity;
    }

    @ManyToOne
    @JoinColumn(name = "accountEntityId", updatable = false, insertable = false)
    @JsonBackReference(value = "account-mess")
    private AccountEntity accountEntity;

    @ManyToOne
    @JoinColumn(name = "roomChatEntityId", updatable = false, insertable = false)
    @JsonBackReference(value = "mes-room")
    private RoomChatEntity roomChatEntity;


    public MessageEntity() {

    }

    public MessageEntity(String createBy, String modifiedBy, String content, Integer accountEntityId,
                         Integer roomChatEntityId, AccountEntity accountEntity, RoomChatEntity roomChatEntity) {
        super(createBy, modifiedBy);
        this.content = content;
        this.accountEntityId = accountEntityId;
        this.roomChatEntityId = roomChatEntityId;
        this.accountEntity = accountEntity;
        this.roomChatEntity = roomChatEntity;
    }

    public MessageEntity(String createBy, String modifiedBy, String content, AccountEntity accountEntity) {
        super(createBy, modifiedBy);
        this.content = content;
        this.accountEntity = accountEntity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
