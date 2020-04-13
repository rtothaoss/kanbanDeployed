package academy.learnprogramming.kanban.services;

import academy.learnprogramming.kanban.domain.User;
import academy.learnprogramming.kanban.exceptions.UsernameAlreadyExistsException;
import academy.learnprogramming.kanban.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User newUser) {

        try{
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

            newUser.setUsername(newUser.getUsername());

            newUser.setConfirmPassword("");

            return userRepository.save(newUser);
        }
        catch(Exception e) {
            throw new UsernameAlreadyExistsException("Username '" + newUser.getUsername() + "' already exists.");
        }


    }

}
