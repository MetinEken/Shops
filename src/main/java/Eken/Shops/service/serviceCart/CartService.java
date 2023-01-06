package Eken.Shops.service.serviceCart;

import Eken.Shops.request.CartReq;
import Eken.Shops.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public interface CartService {
    ResponseEntity<Response> addNewCart(CartReq cartReq);

    ResponseEntity<Response> deleteCart(CartReq cartReq);

    ResponseEntity<Response> updateCart(CartReq cartReq);
}
