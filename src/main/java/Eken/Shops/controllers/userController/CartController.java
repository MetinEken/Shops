package Eken.Shops.controllers.userController;

import Eken.Shops.request.CartReq;
import Eken.Shops.response.Response;
import Eken.Shops.service.serviceCart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

   //tek urun ekle methodu silindi, tum urunler liste seklinde eklenecek, ui dan liste seklinde alinacak
// liste halinde alindi, duzgun calsiyor, login esnasinda list seklinde sepet urunu gelebilir.
    // tum sepete urun eklemeler list seklinde gonderilebilir. code fazlaligindan kurtuluruz.
    // liste seklinde gelenleri daatbase den bulup ayni urunun adetini ve fiyatini guncelliyor.
@PostMapping("/addListCart")
    public ResponseEntity<Response> addNewCart(@RequestBody List<@Valid CartReq> cartReq){
    Response response = new Response();
   cartReq.stream().map(n -> cartService.addNewCart((CartReq) n) ).collect(Collectors.toList());
    response.setSuccess(true);
    response.setMessage("New product added to cart");
    return new ResponseEntity<>(response, HttpStatus.OK);
}
//delete islemi basarili, urunleri tek tek siliyoruz.
    // urunler satin alindigi zaman topluca sepetten silinmesi gerekiyor !!!
    //toplu silinme basarili
    // tek tek de silinebilir
@DeleteMapping("/deleteCart")
    public ResponseEntity<Response> deleteCart(@RequestBody List<@Valid CartReq> cartReq){
    Response response = new Response();
       cartReq.stream().map(n -> cartService.deleteCart((CartReq)  n)).collect(Collectors.toList());
    response.setSuccess(true);
    response.setMessage("All product deleted to cart");
    return new ResponseEntity<>(response, HttpStatus.OK);


}
// updateCart calisiyor, urun adeti 0 ise siliyor, digerlerini guncelliyor
    // bu method tek tek calisiyor, liste halinde yapilamaz.
@PatchMapping("/updateCart")
    public ResponseEntity<Response> updateCart(@RequestBody CartReq cartReq){
        return cartService.updateCart(cartReq);
}



}
