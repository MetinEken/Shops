package Eken.Shops.response;

import lombok.Data;
import org.springframework.http.converter.json.GsonBuilderUtils;

@Data
public class ProductCartList {
    private Long id;
    private String name;
    private double currentPrice;
    private double oldPrice;
    private boolean isExist;
//    private boolean isShow;
    private int star;
    private int numComments;
    private String img1;

}
