package Eken.Shops.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryAddReq {

    private String categoryTable;
    private String name;
    private Long topCtg;
}
