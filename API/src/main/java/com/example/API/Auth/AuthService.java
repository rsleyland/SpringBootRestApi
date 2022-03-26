package com.example.API.Auth;

import com.example.API.Address;
import com.example.API.BaseUser.BaseUser;
import com.example.API.BaseUser.BaseUserRepository;
import com.example.API.Gender;
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

    public Optional<BaseUser> registerNewUser(String fn, String ln, String email, String password, Gender gender, Address address) {
        Optional<BaseUser> alreadyExists = baseUserRepository.findBaseUserByEmail(email);
        if (!alreadyExists.isPresent()) {
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
            BaseUser user = new BaseUser(fn, ln, email, hashedPassword, gender, address, LocalDateTime.now());
            baseUserRepository.insert(user);
            Optional<BaseUser> optUser = Optional.of(user);
            System.out.println("User created successfully!");
            return optUser;
        } else {
            System.out.println("Already a user with that email!");
            return null;
        }

    };
};