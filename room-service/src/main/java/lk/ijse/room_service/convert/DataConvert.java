package lk.ijse.room_service.convert;

import lk.ijse.room_service.dto.RoomDTO;
import lk.ijse.room_service.entity.RoomEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataConvert {

    private final ModelMapper modelMapper;


    public RoomDTO roomEntityConvertRoomDTO(RoomEntity roomEntity){
        return modelMapper.map(roomEntity, RoomDTO.class);
    }

    public RoomEntity roomDTOConvertRoomEntity(RoomDTO roomDTO){
        return modelMapper.map(roomDTO, RoomEntity.class);
    }
}
