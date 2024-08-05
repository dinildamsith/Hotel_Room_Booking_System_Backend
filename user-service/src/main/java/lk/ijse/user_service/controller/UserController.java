package lk.ijse.user_service.controller;


import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/user_service")
@CrossOrigin(origins = "http://localhost:5173", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.PATCH,
        RequestMethod.OPTIONS,

},allowCredentials = "true")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping
    public void healthChecking() {
        System.out.println("User Worked...");
    }

    @PostMapping
    @RequestMapping("/signUp")
    String signUp(@RequestPart ("email") String email,
                  @RequestPart ("contact") String contact,
                  @RequestPart ("name") String name,
                  @RequestPart ("password") String password
                  ){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setContact(contact);
        userDTO.setName(name);
        userDTO.setPassword(password);
        String res = userServices.signUp(userDTO);
        return res;
    }


    @PostMapping
    @RequestMapping("/login/{email}/{password}")
    String signIn(@PathVariable ("email") String email , @PathVariable ("password") String password){
        String res = userServices.signIn(email, password);
        return res;
    }

    @GetMapping
    @RequestMapping("/user_exits/{mail}")
    boolean userExitsCheck(@PathVariable ("mail") String mail){
        boolean b = userServices.userExitsCheck(mail);
        return b;
    }

}