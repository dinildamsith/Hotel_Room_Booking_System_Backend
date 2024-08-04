package lk.ijse.room_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/room_service")
public class RoomController {

    @GetMapping
    String checkHealth(){
        return "Worked...";
    }
}
