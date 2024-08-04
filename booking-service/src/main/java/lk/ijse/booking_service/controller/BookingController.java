package lk.ijse.booking_service.controller;

import jakarta.annotation.PostConstruct;
import lk.ijse.booking_service.dto.BookingDTO;
import lk.ijse.booking_service.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking_service")
public class BookingController {

    @Autowired
    BookingServices bookingServices;

    @PostMapping
    public void checkHealth(){
        System.out.println("Booking worked...");
    }

    @PostConstruct
    public void updateRoomStatusesForExpiredBookings(){
        bookingServices.updateRoomStatusesForExpiredBookings();;
    }

    @PostMapping
    @RequestMapping("/room_booking")
    public String roomBook(@RequestBody BookingDTO bookingDTO){
        String res = bookingServices.roomBooking(bookingDTO);
        return  res;
    }

}
