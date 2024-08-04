package lk.ijse.room_service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.room_service.entity.SuperEntity;
import lk.ijse.room_service.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO implements SuperDTO {
    private int roomId;
    private String roomPic;
    private RoomType roomType;
    private int beadCount;
    private double oneDayPrice;
    private String roomStatus;


}
