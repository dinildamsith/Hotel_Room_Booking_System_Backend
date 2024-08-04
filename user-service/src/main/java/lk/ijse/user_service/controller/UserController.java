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
    @RequestMapping("/signUp")
    String signUp(@RequestBody UserDTO userDTO){
        String res = userServices.signUp(userDTO);
        return res;
    }


    @PostMapping
    @RequestMapping("/login/{email}/{password}")
    String signIn(@PathVariable ("email") String email , @PathVariable ("password") String password){
        String res = userServices.signIn(email, password);
        return res;
    }

}