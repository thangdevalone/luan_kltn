package com.apec.pos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apec.pos.PosApplication;
import com.apec.pos.dto.MessageDto.MessageResponse;
import com.apec.pos.dto.RoomDto.GetListRoomResponse;
import com.apec.pos.dto.RoomDto.InfoReceiver;
import com.apec.pos.dto.RoomDto.LastMess;
import com.apec.pos.entity.AccountEntity;
import com.apec.pos.entity.MessageEntity;
import com.apec.pos.entity.RoomChatEntity;
import com.apec.pos.repository.AccountRepository;
import com.apec.pos.repository.MessageRepository;
import com.apec.pos.repository.RoomChatRepository;
import com.apec.pos.service.serviceInterface.RoomChatInterface;

@Service
public class RoomService extends BaseService<RoomChatRepository, RoomChatEntity, Integer> implements RoomChatInterface {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private RoomChatRepository roomChatRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    RoomChatRepository getRepository() {
        return roomChatRepository;
    }

    public RoomChatEntity getRoomChat(Integer id) {
        return roomChatRepository.findOne(id);
    }

    public RoomChatEntity addRoom(Integer shipperId, Integer userId) {
        RoomChatEntity roomChatEntity = new RoomChatEntity();
        roomChatEntity.setShipperId(shipperId);
        roomChatEntity.setUserId(userId);


        return roomChatRepository.insert(roomChatEntity);
    }

//    @Override
//    public List<GetListRoomResponse> getListRoomResponses() {
//        List<GetListRoomResponse> result = new ArrayList<>();
//
//        String username = PosApplication.currentUserGlobal;
//        AccountEntity accountSend = accountRepository.findByUsername(username);
//        Integer idReceiver = null;
//        List<RoomChatEntity> roomChatEntities = roomChatRepository.getListRoom(accountSend.getId());
//        System.out.println("roomChatEntites:" + roomChatEntities);
//        for (RoomChatEntity x : roomChatEntities) {
//            GetListRoomResponse temp = new GetListRoomResponse();
//            InfoReceiver infoReceiver = new InfoReceiver();
//            LastMess lastMess = new LastMess();
//            AccountEntity accountRecei = new AccountEntity();
//
//            if (x.getShipperId() != accountSend.getId()) {
//                System.out.println("accountSend:" + accountSend.getId());
//                accountRecei = accountRepository.findOne(x.getShipperId());
//            }
//            if (x.getUserId() != accountSend.getId()) {
//                System.out.println("accountSend:" + accountSend.getId());
//                accountRecei = accountRepository.findOne(x.getShipperId());
//            }
//
//            infoReceiver.setAccountName(accountRecei.getAccountName());
//            infoReceiver.setId(accountRecei.getId());
//            infoReceiver.setImgAccount(accountRecei.getImgUser());
//            infoReceiver.setUsername(accountRecei.getUsername());
//
//            MessageEntity messageEntity = messageRepository.getListLassMess(accountSend.getId()).get(0);
//            lastMess.setContent(messageEntity.getContent());
//            lastMess.setCreateAt(messageEntity.getCreateDate());
//            lastMess.setSendId(accountSend.getId());
//
//            temp.setInfoReceiver(infoReceiver);
//            temp.setLastMess(lastMess);
//            temp.setRoomId(x.getId());
//
//            result.add(temp);
//        }
//
//        return result;
//    }

    @Override
    public List<MessageResponse> getListRoomChat(Integer roomId) {
        List<MessageResponse> messageResponses = new ArrayList<>();
        List<MessageEntity> messageEntities = messageRepository.getListChatRoom(roomId);
        for (MessageEntity x : messageEntities) {
            MessageResponse messageResponse = new MessageResponse();
            messageResponse.setContent(x.getContent());
            messageResponse.setCreateAt(x.getCreateDate());
            messageResponse.setId(x.getId());
            messageResponse.setSendId(x.getAccountEntityId());
            messageResponse.setRoomId(x.getRoomChatEntityId());
            messageResponses.add(messageResponse);
        }
        return messageResponses;
    }
}
