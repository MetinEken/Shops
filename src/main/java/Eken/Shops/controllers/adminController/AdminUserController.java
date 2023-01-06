package Eken.Shops.controllers.adminController;

import Eken.Shops.request.RoleAddDeneme;
import Eken.Shops.request.UserRoleReq;
import Eken.Shops.response.Response;

import Eken.Shops.response.UserAllRes;
import Eken.Shops.service.adminService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    AdminService adminService;

//Calisiyor, Ui dan 2 farkli form ile silme islemi yapilabilir, Requestbody guncellenir

    @DeleteMapping("/deleteRole")
    public ResponseEntity<Response> deleteRole(@RequestBody UserRoleReq userRoleReq){
       return      adminService.deleteRole(userRoleReq);
    }
// Calisiyor, Ui dan farkli 2 form(user ve role) gonderildigi zaman Requestbody si degistirilir.
    @PatchMapping("/addAdmin")
    public ResponseEntity<Response> addRole2(@RequestBody RoleAddDeneme roleAddDeneme){
        return adminService.addAdmin2(roleAddDeneme);
    }
    //calisiyor, userres clsi ile cozuldu sorun
    @GetMapping("/getAllUser")
    public List<UserAllRes> users(){
   return      adminService.getAllUser();
        }
}
