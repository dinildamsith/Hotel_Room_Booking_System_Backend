package lk.ijse.booking_service.convert;

import lk.ijse.booking_service.dto.BookingDTO;
import lk.ijse.booking_service.entity.BookingEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataConvert {

    private final ModelMapper modelMapper;

    public BookingEntity bookingDTOConvertBookingEntity(BookingDTO bookingDTO){
        return modelMapper.map(bookingDTO, BookingEntity.class);
    }

    public BookingDTO bookingEntityConvertBookingDTO(BookingEntity bookingEntity){
        return modelMapper.map(bookingEntity, BookingDTO.class);
    }


}
