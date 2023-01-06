package Eken.Shops.service.serviceProduct;

import Eken.Shops.model.ProductAbout;
import Eken.Shops.model.Products;
import Eken.Shops.request.CategoryGetReq;
import Eken.Shops.response.ProductAboutRes;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Products> getAllProduct();

    Optional<Products> getProdById(Products products);

    List<ProductAboutRes> getProdAbout(Products products);


    List<Products> getProdByCatg(CategoryGetReq categoryGetReq);
}
