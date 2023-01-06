package Eken.Shops.service.adminService;

import Eken.Shops.model.User;
import Eken.Shops.response.TransacRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransacService {
    List<TransacRes> getAllTransac();

    List<TransacRes> getTransacById(User user);
}
