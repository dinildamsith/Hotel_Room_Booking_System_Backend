package lk.ijse.user_service.service;


import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.entity.UserEntity;

public interface UserServices {
    String signUp(UserDTO userDTO);
    String signIn(String email , String password);
    boolean userExitsCheck(String userMail);
    UserEntity getUserAllDetails(String userMail);
}
