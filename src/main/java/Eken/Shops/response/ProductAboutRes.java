package Eken.Shops.response;

import Eken.Shops.model.ProductAbout;
import Eken.Shops.model.User;
import lombok.Data;

@Data
public class ProductAboutRes {
    private Long id;
    private String about;
    private String img;


    public ProductAboutRes(ProductAbout entity){
        this.id= entity.getId();
        this.about= entity.getAbout();
        this.img= entity.getImg();
    }

}


//    public UserAllRes(User entity){
//        this.id = entity.getId();
//        this.userName = entity.getUserName();
//        this.email =entity.getEmail();
//        this.name =entity.getName();
//        this.lastName = entity.getLastName();
//        this.date =entity.getDate();
//        this.provider= entity.getProvider();
//        this.loginDates = entity.getLoginDates();
//    }