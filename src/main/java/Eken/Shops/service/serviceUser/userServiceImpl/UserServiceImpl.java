package Eken.Shops.service.serviceUser.userServiceImpl;

import Eken.Shops.model.Cart;
import Eken.Shops.model.SoldProducts;
import Eken.Shops.model.Transaction;
import Eken.Shops.model.Address;
import Eken.Shops.model.Role;
import Eken.Shops.model.User;
import Eken.Shops.model.UserRole;
import Eken.Shops.repository.*;
import Eken.Shops.request.CartReq;
import Eken.Shops.request.SignUpForm;
import Eken.Shops.request.TransactionReq;
import Eken.Shops.response.Response;
import Eken.Shops.service.serviceCart.CartService;
import Eken.Shops.service.serviceUser.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    TransacRepo transacRepo;

    @Autowired
    SoldProdRepo soldProdRepo;

    @Autowired
    CartService cartService;
    @Override
    public ResponseEntity<Response> registerByForm(SignUpForm signUpForm) {
        Response response = new Response();

        if(userRepo.existsByUserName(signUpForm.getUserName())){
            response.setMessage("Error: Username is already taken");
            response.setSuccess(false);
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }

        if(userRepo.existsByEmail(signUpForm.getEmail())){
            response.setMessage("Error: Email is already taken");
            response.setSuccess(false);
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }
        User user = new User(
                signUpForm.getUserName(),
                signUpForm.getName(),
                signUpForm.getEmail(),
                signUpForm.getLastName(),
                signUpForm.getPassword());

        Set<UserRole> userRoles = new HashSet<>();
        Set<String> stringRoles = Collections.singleton(signUpForm.getRole());

        stringRoles.forEach(name -> {
            Role role = (Role) roleRepo.findByName(name).
                    orElseThrow(() -> new RuntimeException("User Role Not found"));
            userRoles.add(new UserRole(user, role));
        });
        Date date = new Date();
        user.setDate(date);
        user.setUserRole(userRoles);
        userRepo.save(user);
        response.setMessage("User registered Successfuly");
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> updateMyProfile(User user) {
        Response response = new Response();
        User userT = userRepo.findByEmail(user.getEmail());
    userT.setName(user.getName());
    userT.setLastName(user.getLastName());
    userT.setUserName(user.getUserName());

    userRepo.save(userT);
        response.setMessage("User registered Successfuly");
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> addAddress(Address address) {
        Response response = new Response();
        try{
            addressRepo.save(address);
            response.setMessage("Address added is Successfuly");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setMessage("Address add is Failed");
            response.setSuccess(false);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Response> deleteAddress(Address address) {
        Response response = new Response();
        try{
            addressRepo.delete(address);
            response.setMessage("Address deleted is Successfuly");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setMessage("Address deleted is Failed");
            response.setSuccess(false);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public ResponseEntity<Response> addTransaction(TransactionReq transactionReq) {
        Response response = new Response();
        try{
            Date date = new Date();
            Transaction transaction = new Transaction();
            transaction.setPayMethod(transactionReq.getTransaction().getPayMethod());
            transaction.setTotal(transactionReq.getTransaction().getTotal());
            transaction.setDate(date);
            transaction.setUser(transactionReq.getTransaction().getUser());
            transaction.setAddress(transactionReq.getTransaction().getAddress());
         Transaction transaction1 = transacRepo.save(transaction);  // burada yeni eklenen transaction in id sini aldik.
         transactionReq.getCart().forEach(cart -> {
                soldProductAdd(cart ,transaction1, date);
            });
            response.setMessage("New transaction is Successfuly added");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setMessage("New transaction is Failed !!!");
            response.setSuccess(false);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } }
    public void soldProductAdd(Cart cart, Transaction transaction, Date date){
        SoldProducts soldProducts = new SoldProducts();
        try{
        soldProducts.setProducts(cart.getProducts());
        soldProducts.setPiece(cart.getPiece());
        soldProducts.setPreice(cart.getPreice());
        soldProducts.setTotal(cart.getPiece() * cart.getPreice());
        soldProducts.setTransaction(transaction);
        soldProducts.setDate(date);
        soldProducts.setUser(cart.getUser());
        soldProducts.setAddress(transaction.getAddress());
        soldProducts.setCompId(cart.getProducts().getCompId());
        soldProdRepo.save(soldProducts);
        this.transportCartReq(cart);
        }catch (Exception e){
        }
    }
    // burda satilan urunler sepetten siliniyor
    public void transportCartReq(Cart cart){
        CartReq cartReq = new CartReq();
        try {
            cartReq.setId(cart.getId());
            cartService.deleteCart(cartReq);
        }catch (Exception e){}
    }

}
