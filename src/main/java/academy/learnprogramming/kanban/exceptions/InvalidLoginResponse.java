package academy.learnprogramming.kanban.exceptions;


import lombok.Getter;
import lombok.Setter;

public class InvalidLoginResponse {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    public InvalidLoginResponse() {
        this.username = "Invalid Username";
        this.password = "Invalid Password";
    }
}
