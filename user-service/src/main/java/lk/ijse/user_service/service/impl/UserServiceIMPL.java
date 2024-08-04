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

@Transactional
@Service
public class UserServiceIMPL implements UserServices{

    @Autowired
    UserRepo userRepo;

    @Autowired
    DataConvert dataConvert;


    @Override
    public String saveUser(UserDTO userDTO) {
        return null;
    }
}
