package com.example.API.Auth;

import com.example.API.Address;
import com.example.API.BaseUser.BaseUser;
import com.example.API.BaseUser.BaseUserRepository;
import com.example.API.Gender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {

    private BaseUserRepository baseUserRepository;



    public AuthService(BaseUserRepository baseUserRepository) {
        super();
        this.baseUserRepository = baseUserRepository;
    }

    public ResponseEntity<?> register(String fn, String ln, String email, String password, Gender gender, Address address) {
        Optional<BaseUser> alreadyExists = baseUserRepository.findBaseUserByEmail(email);
        if (!alreadyExists.isPresent()) {
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
            BaseUser user = new BaseUser(fn, ln, email, hashedPassword, gender, address, LocalDateTime.now());
            baseUserRepository.insert(user);
            user.setPassword("HIDDEN");
            Optional<BaseUser> optUser = Optional.of(user);
            System.out.println("User created successfully!");
            return new ResponseEntity<>(optUser, HttpStatus.OK);
        } else {
            System.out.println("Already a user with that email!");
            return new ResponseEntity<>("Already user with that email!", HttpStatus.BAD_REQUEST);
        }
    };

    public ResponseEntity<?> login(String email, String password) {
        Optional<BaseUser> user = baseUserRepository.findBaseUserByEmail(email);
        if (user.isPresent()) {
            boolean passMatch = BCrypt.checkpw(password, user.get().getPassword());
            if (passMatch) {
                user.get().setPassword("HIDDEN");
                System.out.println("User logged in successfully!");
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
            else {
                System.out.println("Password is incorrect!");
                return new ResponseEntity<>("Password is incorrect", HttpStatus.BAD_REQUEST);
            }
        } else {
            System.out.println("No user with that email!");
            return new ResponseEntity<>("No user with that email!", HttpStatus.BAD_REQUEST);
        }
    };
};