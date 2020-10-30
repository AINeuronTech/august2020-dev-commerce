package com.aint.commerce.restcontroller;

import com.aint.commerce.entity.Product;
import com.aint.commerce.entity.UserProfile;
import com.aint.commerce.services.AuthenticationService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@ApiResponses( value = {
        @ApiResponse(code = 400, message = "This is bad client call, please read the API GET format"),
        @ApiResponse(code = 401, message = "Security Enabled, Need Authorization"),
        @ApiResponse(code = 500, message = "probably Server is down, Please Contact Admin/DevOps@aineurontech.com"),
})
@CrossOrigin(origins = "*")
public class Authentication {


    public AuthenticationService authenticationService;

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public ResponseEntity<UserProfile> getProfile(UserProfile userProfile) {

        Optional<UserProfile> userProfileFound = Optional.ofNullable(authenticationService.findByUserEmail(userProfile.getUserName()));
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }

    @PostMapping("/signUp")
    public ResponseEntity<String> savePerson(@RequestBody UserProfile userProfile) {

        authenticationService.createProfile(userProfile);
        return new ResponseEntity<>("userProfile is created", HttpStatus.OK);
    }



    /*
    @GetMapping(value = "/login", headers = "Accept=application/json")
    public ResponseEntity<Void> createProfile(@RequestBody Product product, UriComponentsBuilder uriComponentsBuilder){

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute("userForm") UserProfile userForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        authenticationService.save(userForm);

        return "redirect:/welcome";
    }  */
}
