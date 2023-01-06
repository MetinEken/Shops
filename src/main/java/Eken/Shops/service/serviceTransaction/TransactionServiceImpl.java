package Eken.Shops.service.serviceTransaction;

import Eken.Shops.model.Cart;
import Eken.Shops.model.SoldProducts;
import Eken.Shops.model.Transaction;
import Eken.Shops.repository.CartRepo;
import Eken.Shops.repository.SoldProdRepo;
import Eken.Shops.repository.TransacRepo;
import Eken.Shops.request.CartReq;
import Eken.Shops.request.TransactionReq;
import Eken.Shops.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransacRepo transacRepo;
    @Autowired
    CartRepo cartRepo;
    @Autowired
    SoldProdRepo soldProdRepo;
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
            soldProducts.setStatus("New");
            soldProducts.setAddress(transaction.getAddress());
            soldProducts.setCompId(cart.getProducts().getCompId());
            soldProdRepo.save(soldProducts);
            cartRepo.deleteById(cart.getId()); // burda satilan urunler sepetten siliniyor
        }catch (Exception e){  }


    }


}
