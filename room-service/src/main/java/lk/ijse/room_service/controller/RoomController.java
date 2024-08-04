package lk.ijse.room_service.controller;

import lk.ijse.room_service.dto.RoomDTO;
import lk.ijse.room_service.entity.RoomEntity;
import lk.ijse.room_service.enums.RoomType;
import lk.ijse.room_service.service.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/room_service")
public class RoomController {

    @Autowired
    RoomServices roomServices;

    @GetMapping
    String checkHealth(){
        return "Worked...";
    }


    @RequestMapping("/save")
    String saveRoom(@RequestPart("roomId") String roomId,
                    @RequestPart("roomPic") String roomPic,
                    @RequestPart("roomType") String roomType,
                    @RequestPart("beadCount") String beadCount,
                    @RequestPart("oneDayPrice") String oneDayPrice
                               ){

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomId(Integer.parseInt(roomId));
        roomDTO.setRoomPic(roomPic);
        roomDTO.setRoomType(RoomType.valueOf(roomType));
        roomDTO.setBeadCount(Integer.parseInt(beadCount));
        roomDTO.setOneDayPrice(Double.parseDouble(oneDayPrice));


        String res = roomServices.saveRooms(roomDTO);
        return res;
    }


    @PutMapping
    @RequestMapping("/update/{updateRoomId}")
    String updateRoom(@PathVariable ("updateRoomId") String roomId,
                      @RequestPart("roomPic") String roomPic,
                      @RequestPart("roomType") String roomType,
                      @RequestPart("beadCount") String beadCount,
                      @RequestPart("oneDayPrice") String oneDayPrice
    ){

        RoomDTO updateRoomDTO = new RoomDTO();
        updateRoomDTO.setRoomId(Integer.parseInt(roomId));
        updateRoomDTO.setRoomPic(roomPic);
        updateRoomDTO.setRoomType(RoomType.valueOf(roomType));
        updateRoomDTO.setBeadCount(Integer.parseInt(beadCount));
        updateRoomDTO.setOneDayPrice(Double.parseDouble(oneDayPrice));


        String res = roomServices.updateRooms(roomId,updateRoomDTO);
        return res;
    }


    @GetMapping
    @RequestMapping("/search/{searchRoomId}")
    RoomEntity searchRoom(@PathVariable ("searchRoomId") String searchRoomId){
        RoomEntity searchRoom = roomServices.searchRooms(searchRoomId);
        return searchRoom;
    }
}