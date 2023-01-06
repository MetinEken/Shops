package Eken.Shops.service.adminService.serviceImpl;

import Eken.Shops.model.Transaction;
import Eken.Shops.model.User;
import Eken.Shops.repository.TransacRepo;
import Eken.Shops.response.TransacRes;
import Eken.Shops.service.adminService.TransacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacServiceImpl implements TransacService {

    @Autowired
    TransacRepo transacRepo;
    @Override
    public List<TransacRes> getAllTransac() {
        List<Transaction> list;
        list = transacRepo.findAll();
        return list.stream().map(p -> new TransacRes(p)).collect(Collectors.toList());

    }

    @Override
    public List<TransacRes> getTransacById(User user) {
        List<Transaction> list;
        list = transacRepo.getByUserId(user.getId());
        return list.stream().map(p -> new TransacRes(p)).collect(Collectors.toList());
    }
}
