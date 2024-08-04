package lk.ijse.booking_service.dto;

import lk.ijse.booking_service.enums.RoomType;
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
