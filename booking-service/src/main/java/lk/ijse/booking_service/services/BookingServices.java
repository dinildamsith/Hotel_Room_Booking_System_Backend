package lk.ijse.booking_service.services;

import lk.ijse.booking_service.dto.BookingDTO;

public interface BookingServices {
    String roomBooking(BookingDTO bookingDTO);
    void updateRoomStatusesForExpiredBookings();
}
