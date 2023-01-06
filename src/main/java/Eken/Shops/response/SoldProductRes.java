package Eken.Shops.response;

import Eken.Shops.model.SoldProducts;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class SoldProductRes {
    private Long id;

    private int piece;
    private double preice;
    private double total;
    private Date date;
    private boolean confirm;
    private String status;
    private String postNumber;
    private double cargo_preice;
    private Long compId;
    private Long productId;
    private Long userId;
    private Long transacId;
    private Long addressId;

    public SoldProductRes(SoldProducts entity){
        this.id=entity.getId();
        this.piece= entity.getPiece();
        this.preice= entity.getPreice();
        this.total= entity.getTotal();
        this.date=entity.getDate();
        this.confirm= entity.isConfirm();
        this.status=entity.getStatus();
        this.postNumber= entity.getPostNumber();
        this.cargo_preice= entity.getCargo_preice();
        this.compId= entity.getCompId();
        this.productId=entity.getProducts().getId();
        this.userId=entity.getUser().getId();
        this.transacId=entity.getTransaction().getId();
        this.addressId=entity.getAddress().getId();
    }



}
