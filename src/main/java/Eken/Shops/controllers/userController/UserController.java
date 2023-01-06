package Eken.Shops.controllers.userController;

import Eken.Shops.model.Address;
import Eken.Shops.model.Comments;
import Eken.Shops.model.User;
import Eken.Shops.repository.RoleRepo;
import Eken.Shops.repository.UserRepo;
import Eken.Shops.request.SignUpForm;
import Eken.Shops.request.TransactionReq;
import Eken.Shops.response.Response;
import Eken.Shops.service.serviceUser.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    UserService userService;


//calisiyor
    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody SignUpForm signUpForm){
return  userService.registerByForm(signUpForm);
    }
// calisiyor
    @PatchMapping("/updateProfile")
    public ResponseEntity<Response> updateProfile(@RequestBody User user) {
        return userService.updateMyProfile(user);
    }

// calisiyor
    @PostMapping("/addAddress")
    public ResponseEntity<Response> addAddress(@RequestBody Address address){
        Date date = new Date();
        System.out.println(date);
        return userService.addAddress(address);
    }
// calisiyor ...
    @DeleteMapping("/deleteAddress")
    public ResponseEntity<Response> deleteAddress(@RequestBody Address address){
        return  userService.deleteAddress(address);
    }




}
