package lk.ijse.room_service.dao;

import lk.ijse.room_service.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<RoomEntity,String> {
}
