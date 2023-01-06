package Eken.Shops.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRoleReq {
    private String email;
    private String deleteRole;

    private String addRole;

    public UpdateRoleReq() {
    }

    public UpdateRoleReq(String email, String deleteRole, String addRole) {
        this.email = email;
        this.deleteRole = deleteRole;
        this.addRole = addRole;
    }
}

