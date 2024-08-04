package lk.ijse.user_service.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user_service")
public class UserController {

    @PostMapping
    public void healthChecking() {
        System.out.println("User Worked...");
    }

}