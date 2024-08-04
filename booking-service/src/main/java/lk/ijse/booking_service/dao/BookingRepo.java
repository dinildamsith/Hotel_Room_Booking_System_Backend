package lk.ijse.booking_service.dao;

import lk.ijse.booking_service.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<BookingEntity,String> {

    @Query("SELECT bookingId FROM booking_details ORDER BY bookingId DESC LIMIT 1")
    Integer getLastBookingId();
}
