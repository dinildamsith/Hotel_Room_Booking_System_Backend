package lk.ijse.room_service.service.impl;

import lk.ijse.room_service.convert.DataConvert;
import lk.ijse.room_service.dao.RoomRepo;
import lk.ijse.room_service.dto.RoomDTO;
import lk.ijse.room_service.entity.RoomEntity;
import lk.ijse.room_service.service.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceIMPL implements RoomServices {

    @Autowired
    RoomRepo roomRepo;
    @Autowired
    DataConvert dataConvert;

    @Override
    public List<RoomEntity> getAllRooms() {
        List<RoomEntity> allRooms = roomRepo.findAll();
        return allRooms;
    }

    @Override
    public String saveRooms(RoomDTO roomDTO) {
        if (roomRepo.existsById(String.valueOf(roomDTO.getRoomId()))){
            return "This Id Have Already Room";
        }else{
            roomRepo.save(dataConvert.roomDTOConvertRoomEntity(roomDTO));
            return "Room Saved...";
        }
    }

    @Override
    public RoomEntity searchRooms(String roomId) {
        if (roomRepo.existsById(roomId)){
            RoomEntity searchRoom = roomRepo.findById(roomId).orElse(null);
            return searchRoom;
        }else{
            return null;
        }
    }

    @Override
    public String updateRooms(String updateRoomId, RoomDTO roomDTO) {

        if (roomRepo.existsById(updateRoomId)){
            RoomEntity updateRoomEntity = roomRepo.findById(updateRoomId).orElse(null);
            updateRoomEntity.setRoomPic(roomDTO.getRoomPic());
            updateRoomEntity.setRoomType(roomDTO.getRoomType());
            updateRoomEntity.setBeadCount(roomDTO.getBeadCount());
            updateRoomEntity.setOneDayPrice(roomDTO.getOneDayPrice());

            roomRepo.save(updateRoomEntity);
            return "room updated";
        }else{
            return "this id have no room";
        }
    }

    @Override
    public String checkRoomAvailable(String roomId) {
        if (roomRepo.existsById(roomId)){
            String roomStatus = roomRepo.getRoomStatus(roomId);
            return roomStatus;
        }else {
            return "This Id Have No Room";
        }

    }

    @Override
    public String roomStatusUpdate(String roomId, String updateStatus) {
        if (roomRepo.existsById(roomId)){
            RoomEntity roomEntity = roomRepo.findById(roomId).orElse(null);
            roomEntity.setRoomStatus(updateStatus);
            roomRepo.save(roomEntity);
            return "Status Updated";
        }else {
            return "this id have no room";
        }
    }

}
