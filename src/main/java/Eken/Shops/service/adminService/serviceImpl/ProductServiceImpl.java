package Eken.Shops.service.adminService.serviceImpl;

import Eken.Shops.model.*;
import Eken.Shops.repository.*;
import Eken.Shops.request.CategoryAddReq;
import Eken.Shops.request.CategoryGetReq;
import Eken.Shops.response.ProductAboutRes;
import Eken.Shops.response.Response;
import Eken.Shops.service.adminService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryMainRep categoryMainRep;
    @Autowired
    CategorySecondRep categorySecondRep;

    @Autowired
    CategoryThirdRep categoryThirdRep;
    @Autowired
    CategoryFourthRep categoryFourthRep;
    @Autowired
    ProductAboutRep productAboutRep;



    @Override
    public ResponseEntity<Response> addProduct(Products products) {
        Response response = new Response();
        productRepo.save(products);
        response.setMessage("New Product addded Successfuly");
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public List<Products> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Products> getProduct(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public ResponseEntity<Response> addCategory(CategoryAddReq categoryAddReq) {
        Response response = new Response();
        response.setMessage("New SecondCtegory : "+categoryAddReq.getName()+" addded Failed");
        response.setSuccess(false);
        try {
            if (categoryAddReq.getCategoryTable().equals("CategoryMain")) {
                CategoryMain categoryMain = new CategoryMain();
                categoryMain.setName(categoryAddReq.getName());
                categoryMainRep.save(categoryMain);
                response.setMessage("New MainCtegory : "+categoryAddReq.getName()+" addded Successfuly");
                response.setSuccess(true);
                }else if(categoryAddReq.getCategoryTable().equals("CategorySecond")){
                CategoryMain categoryMain = categoryMainRep.getById(categoryAddReq.getTopCtg());
                CategorySecond categorySecond = new CategorySecond();
                categorySecond.setName(categoryAddReq.getName());
                categorySecond.setCategoryMain(categoryMain);
              categorySecondRep.save(categorySecond);
                response.setMessage("New SecondCtegory : "+categoryAddReq.getName()+" addded Successfuly");
                response.setSuccess(true);
            } else if (categoryAddReq.getCategoryTable().equals("CategoryThird")) {
                CategorySecond categorySecond = categorySecondRep.getById(categoryAddReq.getTopCtg());
                CategoryThird categoryThird = new CategoryThird();
                categoryThird.setName(categoryAddReq.getName());
                categoryThird.setCategorySecond(categorySecond);
                categoryThirdRep.save(categoryThird);
                response.setMessage("New ThirdCtegory : "+categoryAddReq.getName()+" addded Successfuly");
                response.setSuccess(true);
            } else if (categoryAddReq.getCategoryTable().equals("CategoryFourth")) {
                CategoryThird categoryThird = categoryThirdRep.getById(categoryAddReq.getTopCtg());
                CategoryFourth categoryFourth = new CategoryFourth();
                categoryFourth.setName(categoryAddReq.getName());
                categoryFourth.setCategoryThird(categoryThird);
                categoryFourthRep.save(categoryFourth);
                response.setMessage("New FourthCtegory : "+categoryAddReq.getName()+" addded Successfuly");
                response.setSuccess(true);
            }

        } catch (Exception e) {
            response.setMessage("New Product addded Successfuly");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public Optional<Object> getCategory(CategoryGetReq categoryGetReq) {
             try {
            if (categoryGetReq.getCategoryTable().equals("CategoryMain")) {
                return Optional.of(categoryMainRep.findAll());
            } else if (categoryGetReq.getCategoryTable().equals("CategorySecond")) {
                return Optional.ofNullable(categorySecondRep.getByCtgm(categoryGetReq.getTopCtg()));
            } else if (categoryGetReq.getCategoryTable().equals("CategoryThird")) {
                return Optional.ofNullable(categoryThirdRep.getByCtg(categoryGetReq.getTopCtg()));
                //return Optional.of(categoryThirdRep.findAll());
            } else if (categoryGetReq.getCategoryTable().equals("CategoryFourth")) {
                return Optional.ofNullable(categoryFourthRep.getByCtg(categoryGetReq.getTopCtg()));
                //return Optional.of(categoryFourthRep.findAll());
            } }catch (Exception e){ } return null;
             //bu method sadece kategorileri getiriyor
    }

    @Override
    public List<ProductAboutRes> getProdAbout(Products products) {
        List<ProductAbout> productAbout;
        productAbout = productAboutRep.findByProducts(products);
        return  productAbout.stream().map(n -> new ProductAboutRes(n)).collect(Collectors.toList());
    }
//    List<User> user;
//    user = (List<User>) userRepo.findAll();
//        return user.stream().map(n ->new UserAllRes(n)).collect(Collectors.toList());

    @Override
    public ResponseEntity<Response> addProdAbout(ProductAbout productAbout) {
        Response response = new Response();
       // Products products = productRepo.getById(productAbout.getProducts().getId());
//        ProductAbout productAbout1 = new ProductAbout();
//        productAbout1.setAbout(productAbout.getAbout());
//        productAbout1.setImg(productAbout.getImg());
//        productAbout1.setProducts(products);
        try{ productAboutRep.save(productAbout);
            response.setMessage("New product description added successfully");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setMessage("Failed !!!");
            response.setSuccess(false);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

}