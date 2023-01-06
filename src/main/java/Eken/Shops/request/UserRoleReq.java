package Eken.Shops.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserRoleReq {

    private  Long userId;
    private Long roleId;
}
