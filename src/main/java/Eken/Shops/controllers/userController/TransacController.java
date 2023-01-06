package Eken.Shops.controllers.userController;

import Eken.Shops.request.TransactionReq;
import Eken.Shops.response.Response;
import Eken.Shops.service.serviceTransaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class TransacController {
    @Autowired
    TransactionService transactionService;

    // Calisiyor, transactin ve soldproduck birlikte ekleniyor.
    // UI dan TransactionReq formu gonderilemz ise transaction ve soldProduc adli 2 ayri form gonderilir ve metod da guncellenir. ayni method icinde
    // soldProduct simdilik tek urun, bunu bir list yapalim, hem ekleme hem Cart an silme yapilacak
    // satin alinan urunler Cart tablosundan silinme islemi tamamlandi, carttan siliniyor

    @PostMapping("/addTransaction")
    public ResponseEntity<Response> addTransaction(@RequestBody TransactionReq transactionReq){
        return transactionService.addTransaction(transactionReq);
    }
}
