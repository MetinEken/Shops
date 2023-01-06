package Eken.Shops.response;

import Eken.Shops.model.Transaction;
import lombok.Data;

import java.util.Date;
@Data
public class TransacRes {
    private Long id;

    private String payMethod;

    private  double total;

    private Date date;

    private Long userId;
    private String email;
    private String country;
    private String city;

    public TransacRes(Transaction entity){
        this.id= entity.getId();
        this.payMethod= entity.getPayMethod();
        this.total = entity.getTotal();
        this.date =entity.getDate();
        this.userId =entity.getUser().getId();
        this.email =entity.getUser().getEmail();
        this.country =entity.getAddress().getCountry();
        this.city =entity.getAddress().getCity();
    }
}
