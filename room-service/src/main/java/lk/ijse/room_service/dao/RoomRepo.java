package lk.ijse.room_service.dao;

import lk.ijse.room_service.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<RoomEntity,String> {
    @Query(value = "SELECT roomStatus FROM room where roomId=?1" ,nativeQuery = true )
    String getRoomStatus(String roomId);

    @Query(value = "SELECT * FROM room WHERE roomType = ?1 AND oneDayPrice >= ?2 AND oneDayPrice <= ?3", nativeQuery = true)
    List<RoomEntity> getRoomFiltering(String roomType, double minPrice, double maxPrice);


}
