package Eken.Shops.service.adminService.serviceImpl;

import Eken.Shops.model.Role;
import Eken.Shops.model.User;
import Eken.Shops.model.UserRole;
import Eken.Shops.repository.RoleRepo;
import Eken.Shops.repository.UserRepo;
import Eken.Shops.repository.UserRoleRepo;
import Eken.Shops.request.RoleAddDeneme;
import Eken.Shops.request.UserRoleReq;
import Eken.Shops.response.Response;
import Eken.Shops.response.UserAllRes;
import Eken.Shops.service.adminService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserRoleRepo userRoleRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;



    @Override
    public ResponseEntity<Response> deleteRole(UserRoleReq userRoleReq) {
        Response response = new Response();
        try{
        Optional<User> user = userRepo.findById(userRoleReq.getUserId());
        Optional<Role> role = roleRepo.findById(userRoleReq.getRoleId());
        UserRole userRole = userRoleRepo.findByUserIdAndRoleId(user.get().getId(), role.get().getId());
        userRoleRepo.delete(userRole);
            if (role.get().getName() == "USER"){
                Optional<Object> role2 = roleRepo.findByName("RESTRICT");
                RoleAddDeneme roleAddDeneme= new RoleAddDeneme();
                roleAddDeneme.setUser(user.get());
                roleAddDeneme.setRole((Role) role2.get());
                addAdmin2(roleAddDeneme);
                response.setMessage("UserRole 'USER' Deleted And 'RESTRICT' Role Added !!!");
                response.setSuccess(true);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else if (role.get().getName() == "RESTRICT") {
                Optional<Object> role2 = roleRepo.findByName("USER");
                RoleAddDeneme roleAddDeneme= new RoleAddDeneme();
                roleAddDeneme.setUser(user.get());
                roleAddDeneme.setRole((Role) role2.get());
                addAdmin2(roleAddDeneme);
                response.setMessage("UserRole 'RESTRICT Deleted And 'USER' Added !!!");
                response.setSuccess(true);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            response.setMessage("UserRole 'ADMIN' Deleted !!!");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setMessage("UserRole delet is Failed !!!");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Response> addAdmin2(RoleAddDeneme roleAddDeneme) {
        Set<UserRole> userRoles = new HashSet<>();
        User user = roleAddDeneme.getUser();
        Role role = roleAddDeneme.getRole();
        userRoles.add(new UserRole(user, role));
        user.setUserRole(userRoles);
        userRepo.save(user);
        return null;
    }

    @Override
    public List<UserAllRes> getAllUser() {
        List<User> user;
        user = (List<User>) userRepo.findAll();
        return user.stream().map(n ->new UserAllRes(n)).collect(Collectors.toList());
    }
}
