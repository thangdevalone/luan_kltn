package com.apec.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apec.pos.dto.MessageDto.MessageResponse;
import com.apec.pos.dto.MessageDto.MessageSendRequest;
import com.apec.pos.entity.MessageEntity;
import com.apec.pos.repository.MessageRepository;
import com.apec.pos.service.serviceInterface.MessageInterface;

@Service
public class MessageService extends BaseService<MessageRepository, MessageEntity, Integer> implements MessageInterface {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    MessageRepository getRepository() {
        return messageRepository;
    }

    @Override
    public MessageResponse addMessage(MessageSendRequest messageSendRequest) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setContent(messageSendRequest.getContent());
        messageEntity.setAccountEntityId(messageSendRequest.getUserId());
        messageEntity.setRoomChatEntityId(messageSendRequest.getRoomId());
        messageEntity = messageRepository.insert(messageEntity);

        MessageResponse messageResponse = new MessageResponse(
                messageEntity.getId(),
                messageEntity.getContent(),
                messageEntity.getAccountEntityId(),
                messageEntity.getRoomChatEntityId(),
                messageEntity.getCreateDate()
        );


        return messageResponse;
    }
}
