package lk.ijse.booking_service.dao;

import lk.ijse.booking_service.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<BookingEntity,Integer> {

    @Query("SELECT bookingId FROM booking_details ORDER BY bookingId DESC LIMIT 1")
    Integer getLastBookingId();

    @Query("SELECT b FROM booking_details b WHERE b.bookingEndDate <= CURRENT_DATE")
    List<BookingEntity> findExpiredBookings();

}
