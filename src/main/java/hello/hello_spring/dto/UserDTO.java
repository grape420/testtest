package hello.hello_spring.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String userName;
    private String pw;
    private String email;
}
