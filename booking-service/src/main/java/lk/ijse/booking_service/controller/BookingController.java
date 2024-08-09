package lk.ijse.booking_service.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.PostConstruct;
import lk.ijse.booking_service.dto.BookingDTO;
import lk.ijse.booking_service.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

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

    // Run this method every minute
    @Scheduled(fixedRate = 30000) // 30000 milliseconds = 30 seconds
    @Retryable(
            value = { HttpServerErrorException.class },
            maxAttempts = 3,
            backoff = @Backoff(delay = 5000)
    )
    // me @Retryable kiyana eken wene mokakm hari wela me method eka run wena eka fail wunoth aye e method eka try karn kiyan eka
    //  value = { HttpServerErrorException.class },  mehem dila tiyene  "HttpServerErrorException.class" jatiye Exception ekak awoth aye try karn kiyala
    //   maxAttempts = 3,  meme dila tiyene method run eka fail wunam ki park try karna one kiyalad
    public void updateRoomStatusesForExpiredBookings(){
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
