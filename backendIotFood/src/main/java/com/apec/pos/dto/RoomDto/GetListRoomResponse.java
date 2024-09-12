package com.apec.pos.dto.RoomDto;

public class GetListRoomResponse {
    private Integer RoomId;
    private InfoReceiver infoReceiver;
    private LastMess lastMess;

    public Integer getRoomId() {
        return RoomId;
    }

    public void setRoomId(Integer roomId) {
        RoomId = roomId;
    }

    public InfoReceiver getInfoReceiver() {
        return infoReceiver;
    }

    public void setInfoReceiver(InfoReceiver infoReceiver) {
        this.infoReceiver = infoReceiver;
    }

    public LastMess getLastMess() {
        return lastMess;
    }

    public void setLastMess(LastMess lastMess) {
        this.lastMess = lastMess;
    }


}
