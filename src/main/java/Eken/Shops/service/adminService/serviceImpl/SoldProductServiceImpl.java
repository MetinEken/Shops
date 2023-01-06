package Eken.Shops.service.adminService.serviceImpl;

import Eken.Shops.model.SoldProducts;
import Eken.Shops.repository.SoldProdRepo;
import Eken.Shops.response.Response;
import Eken.Shops.response.SoldProductRes;
import Eken.Shops.service.adminService.SoldProdctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoldProductServiceImpl implements SoldProdctService {
    @Autowired
    SoldProdRepo soldProdRepo;


    @Override
    public ResponseEntity<Response> upDateSoldProd(SoldProductRes soldProductRes) {
        Response response = new Response();
        try {
            SoldProducts soldProducts = soldProdRepo.getById(soldProductRes.getId());
            soldProducts.setConfirm(soldProductRes.isConfirm());
            soldProducts.setStatus(soldProductRes.getStatus());
            soldProducts.setCargo_preice(soldProductRes.getCargo_preice());
            soldProducts.setPostNumber(soldProductRes.getPostNumber());
            soldProdRepo.save(soldProducts);
            response.setMessage("Added Succesfully");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setMessage("Added Failed");
            response.setSuccess(false);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @Override
    public List<SoldProductRes> getSoldProdByConfirm(SoldProducts soldProducts) {
        String status =soldProducts.getStatus();
        List<SoldProducts> soldProducts1 =soldProdRepo.findByCompIdAndStatus(soldProducts.getCompId(), status);

        return soldProducts1.stream().map(n -> new SoldProductRes(n)).collect(Collectors.toList());
    }
}
