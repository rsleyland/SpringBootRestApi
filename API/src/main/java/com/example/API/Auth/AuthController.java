package com.example.API.Auth;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;

import com.example.API.Address;
import com.example.API.BaseUser.BaseUser;
import com.example.API.BaseUser.BaseUserService;
import com.example.API.Gender;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> register(@RequestBody String payload) {
        try {
            JSONParser parser = new JSONParser(payload);
            LinkedHashMap<String, Object> obj = parser.parseObject();
            Address address = new Address("Canada", "Montreal", "H2l 4D4");
            Boolean emptyFields = checkForEmptyFields(obj, "register");
            if (emptyFields) {
                System.out.println("FIELDS ARE EMPTY");
                return new ResponseEntity<>("Required input fields were empty", HttpStatus.BAD_REQUEST);
            }
            return authService.register(obj.get("firstName").toString(), obj.get("lastName").toString(), obj.get("email").toString(), obj.get("password").toString(), Gender.MALE, address);
        }
        catch (ParseException pe) {
            System.out.println("Error parsing request body sent by client. " + pe.toString());
            return new ResponseEntity<>("Error parsing request body sent by client.", HttpStatus.BAD_REQUEST);
        }
    };

    @PostMapping ("/login")
    public ResponseEntity<?> login(@RequestBody String payload) {
        try {
            JSONParser parser = new JSONParser(payload);
            LinkedHashMap<String, Object> obj = parser.parseObject();
            Boolean emptyFields = checkForEmptyFields(obj, "login");
            if (emptyFields) {
                System.out.println("FIELDS ARE EMPTY");
                return new ResponseEntity<>("Required input fields were empty", HttpStatus.BAD_REQUEST);
            }
            return authService.login(obj.get("email").toString(), obj.get("password").toString());
        }
        catch (ParseException pe) {
            System.out.println("Error parsing request body sent by client. " + pe.toString());
            return new ResponseEntity<>("Error parsing request body sent by client.", HttpStatus.BAD_REQUEST);
        }
    };

    private boolean checkForEmptyFields(LinkedHashMap<String, Object> obj, String type) {
        String email, password;
        switch (type) {
            case "register":
                String firstName = obj.get("firstName").toString();
                String lastName = obj.get("lastName").toString();
                email = obj.get("email").toString();
                password = obj.get("password").toString();
                return firstName.isBlank() ? true : lastName.isBlank() ? true : email.isBlank() ? true : password.isBlank() ? true : false;
            case "login":
                email = obj.get("email").toString();
                password = obj.get("password").toString();
                return email.isBlank() ? true : password.isBlank() ? true : false;
            default: return true;
        }
    };


};
