package Eken.Shops.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryGetReq {

    private String categoryTable;
    private  Long topCtg;
}
