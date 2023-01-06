package Eken.Shops.request;

import Eken.Shops.model.Cart;
import Eken.Shops.model.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransactionReq {
    Transaction transaction;
    List<Cart> cart;
}
