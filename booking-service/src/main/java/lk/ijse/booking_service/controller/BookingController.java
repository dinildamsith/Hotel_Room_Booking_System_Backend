package lk.ijse.booking_service.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.PostConstruct;
import lk.ijse.booking_service.dto.BookingDTO;
import lk.ijse.booking_service.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/booking_service")
@CrossOrigin(origins = "http://localhost:5173", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.PATCH,
        RequestMethod.OPTIONS,

},allowCredentials = "true")
public class BookingController {

    @Autowired
    BookingServices bookingServices;

    @PostMapping
    public void checkHealth(@RequestPart ("id") String id){
        System.out.println(id);
    }

    @PostConstruct
    public void updateRoomStatusesForExpiredBookings(){
        System.out.println("fff");
        bookingServices.updateRoomStatusesForExpiredBookings();;
    }

    @PostMapping
    @RequestMapping("/room_booking")
    public String roomBook(@RequestPart ("userMail") String mail,
                           @RequestPart ("name") String name,
                           @RequestPart ("roomId") String roomId,
                           @RequestPart ("roomPrice") String price,
                           @RequestPart ("startDate") String startDate,
                           @RequestPart ("endDate") String endDate
    ){

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(0);
        bookingDTO.setGetBookingUserMail(mail);
        bookingDTO.setBookingUserName(name);
        bookingDTO.setBookingRoomId(Integer.parseInt(roomId));
        bookingDTO.setBookingRoomOneDayPrice(Double.parseDouble(price));
        bookingDTO.setBookingStartDate(LocalDate.parse(startDate));
        bookingDTO.setBookingEndDate(LocalDate.parse(endDate));
        String res = bookingServices.roomBooking(bookingDTO);
        return  res;
    }



}
