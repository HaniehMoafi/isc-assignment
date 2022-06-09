package ir.co.isc.controller;


import ir.co.isc.business.interfaces.UserService;
import ir.co.isc.model.DefaultResponse;
import ir.co.isc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/user")
@Validated
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findByCode/{nationalCode}")
    public ResponseEntity<UserModel> findByNationalCode(@PathVariable @NotBlank String nationalCode) {
        UserModel model = userService.findUserDataByNationalCode(nationalCode);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<DefaultResponse> saveUser(@Valid @RequestBody UserModel userModel) {
        DefaultResponse response = new DefaultResponse();
        userService.save(userModel);
        response.setMessage("user is successfully saved");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
