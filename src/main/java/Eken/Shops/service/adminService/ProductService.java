package Eken.Shops.service.adminService;

import Eken.Shops.model.ProductAbout;
import Eken.Shops.model.Products;
import Eken.Shops.request.CategoryAddReq;
import Eken.Shops.request.CategoryGetReq;
import Eken.Shops.response.ProductAboutRes;
import Eken.Shops.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ResponseEntity<Response> addProduct(Products products);

    List<Products> getAllProduct();

    Optional<Products> getProduct(Long id);

    ResponseEntity<Response> addCategory(CategoryAddReq categoryAddReq);

    Optional<Object> getCategory(CategoryGetReq categoryAddReq);

    List<ProductAboutRes> getProdAbout(Products products);

    ResponseEntity<Response> addProdAbout(ProductAbout productAbout);
}
