package lk.ijse.booking_service.services.impl;

import lk.ijse.booking_service.convert.DataConvert;
import lk.ijse.booking_service.dao.BookingRepo;
import lk.ijse.booking_service.dto.BookingDTO;
import lk.ijse.booking_service.dto.RoomDTO;
import lk.ijse.booking_service.entity.BookingEntity;
import lk.ijse.booking_service.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class BookingServiceIMPL implements BookingServices {

    @Autowired
    DataConvert dataConvert;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String roomBooking(BookingDTO bookingDTO) {

        // Room Book Id Auto Set
        Integer lastBookingId = bookingRepo.getLastBookingId();
        if (lastBookingId == null){
            bookingDTO.setBookingId(1);
        }else{
            lastBookingId+=1;
            bookingDTO.setBookingId(lastBookingId);
        }


        // Get Room Status
        String roomStatus = restTemplate.getForObject("http://localhost:8082/api/v1/room_service/get_status/" + bookingDTO.getBookingRoomId(), String.class);


        if (roomStatus.equals("Available")){
            long totalDays = ChronoUnit.DAYS.between(bookingDTO.getBookingStartDate(), bookingDTO.getBookingEndDate())+1;
            bookingDTO.setTotalPrice(totalDays*bookingDTO.getBookingRoomOneDayPrice());
            bookingRepo.save(dataConvert.bookingDTOConvertBookingEntity(bookingDTO));

            // Room Book After Room Status Update
            restTemplate.put("http://localhost:8082/api/v1/room_service/update_status/"+bookingDTO.getBookingRoomId()+"/"+"Unavailable","");
            return "Booking Success";
        }else{
            return "Sorry Sir !!!. This Room Not Available";
        }



    }
}
