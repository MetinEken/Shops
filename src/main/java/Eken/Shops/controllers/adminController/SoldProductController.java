package Eken.Shops.controllers.adminController;

import Eken.Shops.model.Companies;
import Eken.Shops.model.SoldProducts;
import Eken.Shops.response.Response;
import Eken.Shops.response.SoldProductRes;
import Eken.Shops.service.adminService.SoldProdctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class SoldProductController {

@Autowired
SoldProdctService soldProdctService;

    //alinan siparis goruldu, onaylandi tekrar eklendi
    // onaylanip kargoya verilecek urunu cagirip tekrar update edelim. bunun icin sorgu yazalim
    @PostMapping("/upDateSoldProduct")
    public ResponseEntity<Response> upDateSoldProd(@RequestBody SoldProductRes soldProductRes){
       return soldProdctService.upDateSoldProd(soldProductRes);
    }

    // calisiyor
    //burada genel bir sorgu yazdik, urunlerin her durumuna gore sorgu yapilabiliyor.
    //yeni satisi yapilmis urun "New" statusunde ....
    @GetMapping("/getSoldProdByStatus")
    public List<SoldProductRes> getSoldProdByConfirm(@RequestBody SoldProducts soldProducts){
        return soldProdctService.getSoldProdByConfirm(soldProducts);
    }
}
