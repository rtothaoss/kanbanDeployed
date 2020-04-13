package academy.learnprogramming.kanban.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Username cannot be blank")
    @Getter @Setter private String username;
    @NotBlank(message = "Password cannot be blank")
    @Getter @Setter private String password;


}
