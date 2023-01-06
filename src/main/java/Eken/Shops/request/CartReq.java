package Eken.Shops.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartReq {
    private Long id;
    private  int piece;
    private  double preice;
    private Long productsId;
    private Long userId;

}
