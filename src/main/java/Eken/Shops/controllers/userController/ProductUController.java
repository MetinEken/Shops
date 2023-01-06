package Eken.Shops.controllers.userController;

import Eken.Shops.model.Comments;
import Eken.Shops.model.Products;
import Eken.Shops.request.CategoryGetReq;
import Eken.Shops.response.CommentRes;
import Eken.Shops.response.ProductAboutRes;
import Eken.Shops.response.Response;
import Eken.Shops.service.serviceComment.CommentService;
import Eken.Shops.service.serviceProduct.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class ProductUController {
    @Autowired
    ProductService productService;
    @Autowired
    CommentService commentService;


    //calisiyor, duzenlemek gerekiyor
    //Jignor ile calsiti
    //Jignoru sildim, tekrar calisti, ilginc
    @GetMapping("/getAllProduct")
    public List<Products> getAll(){
     return    productService.getAllProduct();
           }

           @GetMapping("/getProdById")
    public Optional<Products> getProdById(@RequestBody Products products){
        return productService.getProdById(products);
           }
//TEK URUNUN ACIKLAMALARININ HEPSI GETIRILIYOR,
    @GetMapping("/getProdAbout")
    public List<ProductAboutRes> getProdAbout(@RequestBody Products products){
        return productService.getProdAbout(products);
           }
//Categoriye gore urunler getirilebiliyor
    //Calisiyor
    //her kategory icin ayri ayri Query yazildi, tek yazilan calismadi.
           @GetMapping("/getProdByCatg")
    public List<Products> getProdByCAtg(@RequestBody CategoryGetReq categoryGetReq){
        return productService.getProdByCatg(categoryGetReq);
           }

//calisiyor, tarih method icinde olusturulup, ekleniyor
    @PostMapping("/addcomment")
    public ResponseEntity<Response> addComment(@RequestBody Comments comments){
        return  commentService.addComment(comments);
    }
//calisiyor... sadece onay verilen yorumlar getiriliyor.
    @GetMapping("/getComment")
    public List<CommentRes> getComment(@RequestBody Products products){
        return commentService.getComments(products);
    }





}
