package Eken.Shops.service.serviceProduct;

import Eken.Shops.model.ProductAbout;
import Eken.Shops.model.Products;
import Eken.Shops.repository.ProductAboutRep;
import Eken.Shops.repository.ProductRepo;
import Eken.Shops.request.CategoryGetReq;
import Eken.Shops.response.ProductAboutRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductUServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductAboutRep productAboutRep;
    @Override
    public List<Products> getAllProduct() {
        return productRepo.findAll();

    }

    @Override
    public Optional<Products> getProdById(Products products) {
        return productRepo.findById(products.getId());
    }

    @Override
    public List<ProductAboutRes> getProdAbout(Products products) {
        List<ProductAbout> productAbout;
        productAbout = productAboutRep.findByProducts(products);
        return  productAbout.stream().map(n -> new ProductAboutRes(n)).collect(Collectors.toList());
      //  return null;
    }

    @Override
    public List<Products> getProdByCatg(CategoryGetReq categoryGetReq) {
        try {
            if (categoryGetReq.getCategoryTable().equals("CategoryMain")) {
                return productRepo.getAllByCtgm(categoryGetReq.getTopCtg());
            } else if (categoryGetReq.getCategoryTable().equals("CategorySecond")) {
                return productRepo.getAllByCtg2(categoryGetReq.getTopCtg());
            } else if (categoryGetReq.getCategoryTable().equals("CategoryThird")) {
                return productRepo.getAllByCtg3(categoryGetReq.getTopCtg());
            } else {
                return productRepo.getAllByCtg4(categoryGetReq.getTopCtg());
            }
        }catch (Exception e){
            return null;
        }
    }
}
