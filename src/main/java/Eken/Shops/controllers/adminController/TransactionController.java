package Eken.Shops.controllers.adminController;

import Eken.Shops.model.Companies;
import Eken.Shops.model.User;
import Eken.Shops.repository.CompaniesRepo;
import Eken.Shops.repository.TransacRepo;
import Eken.Shops.response.TransacRes;
import Eken.Shops.service.adminService.TransacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class TransactionController {

    @Autowired
    TransacRepo transacRepo;

    @Autowired
    CompaniesRepo companiesRepo;

    @Autowired
    TransacService transacService;



    // CALISIYOR , transacRes clasi ile halledildi
    @GetMapping("/getAllTransac")
    public List<TransacRes> getAllTransac(){
    return     transacService.getAllTransac();

    }
    //calisiyor ....
    @GetMapping("/getAllCompanies")
    public List<Companies> getAllCompanies(){
        return companiesRepo.findAll();
    }


    // calisti .....
    @GetMapping("/getTransacById")
    public List<TransacRes> gertById(@RequestBody User user){
        return  transacService.getTransacById(user);
    }


}
