package lk.ijse.user_service.convert;


import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataConvert {

    private final ModelMapper modelMapper;

    public UserDTO userEntityConvertUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public UserEntity userDTOConvertUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
}
