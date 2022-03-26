package com.example.API.Auth;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.API.Address;
import com.example.API.BaseUser.BaseUser;
import com.example.API.BaseUser.BaseUserService;
import com.example.API.Gender;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        super();
        this.authService = authService;
    };

//    @GetMapping("")
//    public List<BaseUser> fetchAllUsers() {
//        return authService.getAllUsers();
//    };

    @PostMapping ("/register")
    public Optional<BaseUser> registerNewUser(@RequestBody String payload) {
        try {

            JSONParser parser = new JSONParser(payload);
            LinkedHashMap<String, Object> obj = parser.parseObject();
            Address address = new Address("Canada", "Montreal", "H2l 4D4");
            Boolean emptyFields = checkNewUserFields(obj);
            if (emptyFields) {
                System.out.println("FIELDS ARE EMPTY");
                return null;
            }
            return authService.registerNewUser(obj.get("firstName").toString(), obj.get("lastName").toString(), obj.get("email").toString(), obj.get("password").toString(), Gender.MALE, address);
        }
        catch (ParseException pe) {
            System.out.println("Error parsing request body sent by client. " + pe.toString());
            return null;
        }

    };

    private boolean checkNewUserFields(LinkedHashMap<String, Object> obj) {
        String firstName = obj.get("firstName").toString();
        String lastName = obj.get("lastName").toString();
        String email = obj.get("email").toString();
        String password = obj.get("password").toString();
        return firstName.isBlank() ? true : lastName.isBlank() ? true : email.isBlank() ? true : password.isBlank() ? true : false;
    }

};
