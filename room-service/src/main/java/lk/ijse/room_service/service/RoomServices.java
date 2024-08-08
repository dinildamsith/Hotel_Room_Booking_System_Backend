package lk.ijse.room_service.service;

import lk.ijse.room_service.dto.RoomDTO;
import lk.ijse.room_service.entity.RoomEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomServices {
    List<RoomEntity> getAllRooms();
    String saveRooms(RoomDTO roomDTO);
    RoomEntity searchRooms(String roomId);
    String updateRooms(String updateRoomId,RoomDTO roomDTO);
    String checkRoomAvailable(String roomId);
    String roomStatusUpdate(String roomId,String updateStatus);
    List<RoomEntity> roomSearchFiltering(String roomType,double minPrice,double maxPrice);

}
