package lk.ijse.booking_service.services.impl;

import jakarta.transaction.Transactional;
import lk.ijse.booking_service.convert.DataConvert;
import lk.ijse.booking_service.dao.BookingRepo;
import lk.ijse.booking_service.dto.BookingDTO;
import lk.ijse.booking_service.dto.RoomDTO;
import lk.ijse.booking_service.entity.BookingEntity;
import lk.ijse.booking_service.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
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
        boolean userExits = restTemplate.getForObject("http://localhost:8082/api/v1/user_service/user_exits/" + bookingDTO.getGetBookingUserMail(), boolean.class);


        if (userExits){
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
        }else{
            return " This Email Have No Registered This System";
        }


    }

    @Override
    public void updateRoomStatusesForExpiredBookings() {
        List<BookingEntity> expiredBookings = bookingRepo.findExpiredBookings();
        for (BookingEntity booking : expiredBookings) {
            try {
                String url = "http://localhost:8082/api/v1/room_service/update_status/" + booking.getBookingRoomId() + "/Available";
                restTemplate.put(url, "");
            } catch (ResourceAccessException e) {
                System.out.println("Handled Exception");
            } catch (Exception e) {
                System.out.println("");
            }
        }
    }
}
