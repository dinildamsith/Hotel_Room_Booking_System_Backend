package lk.ijse.booking_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO implements SuperDTO{
    private int bookingId;
    private String getBookingUserMail;
    private String bookingUserName;
    private int bookingRoomId;
    private double bookingRoomOneDayPrice;
    private LocalDate bookingStartDate;
    private LocalDate bookingEndDate;
    private double totalPrice;
}
