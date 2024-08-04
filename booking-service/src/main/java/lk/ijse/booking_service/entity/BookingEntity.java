package lk.ijse.booking_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "booking_details")
public class BookingEntity implements SuperEntity{
    @Id
    private int bookingId;
    private String getBookingUserMail;
    private String bookingUserName;
    private int bookingRoomId;
    private double bookingRoomOneDayPrice;
    private LocalDate bookingStartDate;
    private LocalDate bookingEndDate;
    private double totalPrice;
}
