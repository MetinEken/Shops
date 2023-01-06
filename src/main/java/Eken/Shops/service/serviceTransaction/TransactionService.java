package Eken.Shops.service.serviceTransaction;

import Eken.Shops.request.TransactionReq;
import Eken.Shops.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    ResponseEntity<Response> addTransaction(TransactionReq transactionReq);
}
