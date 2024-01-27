package com.unibuc.ro.resource;
import com.unibuc.ro.model.UserDetailsDTO;
import com.unibuc.ro.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SignupResource {
    private final UserService userService;

    public SignupResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserDetailsDTO userDetails) {
        userService.save(userDetails);
        return new ResponseEntity(HttpStatus.OK);
    }
}
