package lk.ijse.room_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.room_service.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room")
public class RoomEntity implements SuperEntity{
    @Id
    private int roomId;
    @Column(columnDefinition = "LONGTEXT")
    private String roomPic;
    private RoomType roomType;
    private int beadCount;
    private double oneDayPrice;

}
