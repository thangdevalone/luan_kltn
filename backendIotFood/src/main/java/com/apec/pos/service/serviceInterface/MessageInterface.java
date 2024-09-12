package com.apec.pos.service.serviceInterface;

import com.apec.pos.dto.MessageDto.MessageResponse;
import com.apec.pos.dto.MessageDto.MessageSendRequest;

public interface MessageInterface {

    public MessageResponse addMessage(MessageSendRequest messageSendRequest);
}
