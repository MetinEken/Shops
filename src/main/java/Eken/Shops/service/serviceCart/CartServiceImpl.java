package Eken.Shops.service.serviceCart;

import Eken.Shops.model.Cart;
import Eken.Shops.model.Products;
import Eken.Shops.model.User;
import Eken.Shops.repository.CartRepo;
import Eken.Shops.repository.ProductRepo;
import Eken.Shops.repository.UserRepo;
import Eken.Shops.request.CartReq;
import Eken.Shops.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    CartRepo cartRepo;

    @Override
    public ResponseEntity<Response> addNewCart(CartReq cartReq) {
        Response response = new Response();
        try {
            Optional<User> user = userRepo.findById(cartReq.getUserId());
            Optional<Products> products = productRepo.findById(cartReq.getProductsId());
            try{
            Cart cart =cartRepo.getCartByUserAndProductId(cartReq.getUserId(), cartReq.getProductsId());
                if (cart != null){
                 //   Cart cart2 = new Cart();
                    cart.setPiece(cartReq.getPiece()+ cart.getPiece()); // sepette var olan urun adedine yeni eklenen urun sayisida ekleniyor
                    cart.setPreice(cartReq.getPreice());
                    cart.setUser(user.get());
                    cart.setProducts(products.get());
                    cartRepo.save(cart);
                }else {
                    Cart cart2 = new Cart();
                    cart2.setPiece(cartReq.getPiece());
                    cart2.setPreice(cartReq.getPreice());
                    cart2.setUser(user.get());
                    cart2.setProducts(products.get());
                    cartRepo.save(cart2);

                }
                response.setSuccess(true);
                response.setMessage("New product added to cart");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }catch (Exception e){
                response.setSuccess(false);
                response.setMessage("Failed !!! Ayni urun birden fazla eklenme Hatasi !!!");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage("Failed !!! No value present");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }}

    @Override
    public ResponseEntity<Response> deleteCart(CartReq cartReq) {
        Response response = new Response();
        try {
            cartRepo.deleteById(cartReq.getId());
            response.setSuccess(true);
            response.setMessage("product deleted from cart");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage("Failed !!! No value present");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Response> updateCart(CartReq cartReq) {
        Response response = new Response();
        try {
            Cart cart2 =cartRepo.getCartByUserAndProductId(cartReq.getUserId(), cartReq.getProductsId());
            if (cartReq.getPiece() ==0){
                cartRepo.deleteById(cartReq.getId());
                response.setSuccess(true);
                response.setMessage("product delete from cart");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else {
            cart2.setId(cart2.getId());
            cart2.setPiece(cartReq.getPiece());
            cart2.setPreice(cartReq.getPreice());
            cartRepo.save(cart2);
            response.setSuccess(true);
            response.setMessage("product update from cart");
            return new ResponseEntity<>(response, HttpStatus.OK);}
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage("Failed !!! No value present");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }


}
