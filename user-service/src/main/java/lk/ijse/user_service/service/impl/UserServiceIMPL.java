package lk.ijse.user_service.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.user_service.convert.DataConvert;
import lk.ijse.user_service.dao.UserRepo;
import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.entity.UserEntity;
import lk.ijse.user_service.service.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
public class UserServiceIMPL implements UserServices{

    @Autowired
    UserRepo userRepo;

    @Autowired
    DataConvert dataConvert;


    @Override
    public String signUp(UserDTO userDTO) {

        if (userRepo.existsById(userDTO.getEmail())){
            return "This Mail Have Already Account";
        }else {
            userRepo.save(dataConvert.userDTOConvertUserEntity(userDTO));
            return "Sign Up Done";
        }


    }

    @Override
    public String signIn(String email, String password) {
        if (userRepo.existsById(email)){
            UserEntity user = userRepo.findById(email).orElse(null);
            if (user.getPassword().equals(password)){
                return "Login Success";
            }else{
                return "Email or Password Incorrect";
            }
        }else{
            return "Email or Password Incorrect";
        }
    }

    @Override
    public boolean userExitsCheck(String userMail) {
        if (userRepo.existsById(userMail)){
            return true;
        }else{
            return false;
        }
    }
}
