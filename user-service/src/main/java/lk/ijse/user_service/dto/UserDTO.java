package lk.ijse.user_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements SuperDTO{
    private String email;
    private String name;
    private String contact;
    private String password;
}
