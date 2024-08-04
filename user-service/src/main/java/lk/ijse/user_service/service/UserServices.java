package lk.ijse.user_service.service;


import lk.ijse.user_service.dto.UserDTO;

public interface UserServices {
    String signUp(UserDTO userDTO);
    String signIn(String email , String password);
}
