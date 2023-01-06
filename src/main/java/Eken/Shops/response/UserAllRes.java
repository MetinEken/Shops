package Eken.Shops.response;

import Eken.Shops.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter

public class UserAllRes {
    private Long id;

    private String userName;

    private String email;

    private String name;
    private  String lastName;
    private Date date;
    private String provider=null;
    private String loginDates;
    
    public UserAllRes(){}



    public UserAllRes(List<User> user) {
    }

    public UserAllRes(User entity){
        this.id = entity.getId();
        this.userName = entity.getUserName();
        this.email =entity.getEmail();
        this.name =entity.getName();
        this.lastName = entity.getLastName();
        this.date =entity.getDate();
        this.provider= entity.getProvider();
        this.loginDates = entity.getLoginDates();
    }

    // deneme amacli olusturuldu, calismadi silinebilir
    //entity ile yeni calisma yapiyorum ...
}
