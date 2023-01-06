package Eken.Shops.service.adminService;

import Eken.Shops.request.RoleAddDeneme;
import Eken.Shops.request.UserRoleReq;
import Eken.Shops.response.Response;
import Eken.Shops.response.UserAllRes;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {

    ResponseEntity<Response> deleteRole(UserRoleReq userRoleReq);

    ResponseEntity<Response> addAdmin2(RoleAddDeneme roleAddDeneme);

    List<UserAllRes> getAllUser();
}
