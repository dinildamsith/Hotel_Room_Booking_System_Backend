package lk.ijse.room_service.service;

import lk.ijse.room_service.dto.RoomDTO;
import lk.ijse.room_service.entity.RoomEntity;
import org.springframework.http.ResponseEntity;

public interface RoomServices {
    ResponseEntity<?> getAllRooms();
    String saveRooms(RoomDTO roomDTO);
    RoomEntity searchRooms(String roomId);
    String updateRooms(String updateRoomId,RoomDTO roomDTO);
    String checkRoomAvailable(String roomId);
    String roomStatusUpdate(String roomId,String updateStatus);

}
