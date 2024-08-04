package lk.ijse.user_service.controller;


import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/user_service")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping
    public void healthChecking() {
        System.out.println("User Worked...");
    }

    @PostMapping
    @RequestMapping("/save")
    String saveUser(@RequestBody UserDTO userDTO){
        String res = userServices.saveUser(userDTO);
        return res;
    }

}