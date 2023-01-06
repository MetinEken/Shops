package Eken.Shops.service.adminService;

import Eken.Shops.model.SoldProducts;
import Eken.Shops.response.Response;
import Eken.Shops.response.SoldProductRes;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SoldProdctService {

    ResponseEntity<Response> upDateSoldProd(SoldProductRes soldProductRes);

    List<SoldProductRes> getSoldProdByConfirm(SoldProducts soldProducts);
}
