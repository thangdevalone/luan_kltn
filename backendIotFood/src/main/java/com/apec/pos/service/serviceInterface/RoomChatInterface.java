package com.apec.pos.service.serviceInterface;

import java.util.List;

import com.apec.pos.dto.MessageDto.MessageResponse;
import com.apec.pos.dto.RoomDto.GetListRoomResponse;

public interface RoomChatInterface {

//    public List<GetListRoomResponse> getListRoomResponses();

    public List<MessageResponse> getListRoomChat(Integer roomId);
}
