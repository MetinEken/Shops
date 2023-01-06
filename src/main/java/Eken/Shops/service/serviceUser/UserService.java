package Eken.Shops.service.serviceUser;

import Eken.Shops.model.Address;
import Eken.Shops.model.User;
import Eken.Shops.request.SignUpForm;
import Eken.Shops.request.TransactionReq;
import Eken.Shops.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<Response> registerByForm(SignUpForm signUpForm);

    ResponseEntity<Response> updateMyProfile(User user);

    ResponseEntity<Response> addAddress(Address address);

    ResponseEntity<Response> deleteAddress(Address address);

    List<User> getAllUser();

    ResponseEntity<Response> addTransaction(TransactionReq transactionReq);
}
