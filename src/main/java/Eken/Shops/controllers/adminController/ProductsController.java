package Eken.Shops.controllers.adminController;

import Eken.Shops.model.Comments;
import Eken.Shops.model.ProductAbout;
import Eken.Shops.model.Products;
import Eken.Shops.request.CategoryAddReq;
import Eken.Shops.request.CategoryGetReq;
import Eken.Shops.response.CommentRes;
import Eken.Shops.response.ProductAboutRes;
import Eken.Shops.response.Response;
import Eken.Shops.service.adminService.CommentAService;
import Eken.Shops.service.adminService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class ProductsController {

    @Autowired
    ProductService productService;
    @Autowired
    CommentAService commentAService;



    //calisiyor ... VE updateproduct islemi de bu method ile yapiliyor,
    // yeni eklenen kategorilere gore de urun ekleme yapiyor.
    @PostMapping("/addProduct")
    public ResponseEntity<Response> addProdct(@RequestBody Products products){
        return productService.addProduct(products);
    }
    //calisiyor
    @GetMapping("/getAllProduct")
    public List<Products> getAllProduct(){
        return productService.getAllProduct();
    }

    // calisiyor
    @GetMapping("/product/{id}")
    public Optional<Products> getProductById(@PathVariable Long id){
        return productService.getProduct(id);
    }

    //her bolume ekleme yapabiliyoruz. silme islemi icin method yazilmadi daha
    @PostMapping("/addCategory")
    public ResponseEntity<Response> addcategory(@RequestBody CategoryAddReq categoryAddReq){
return productService.addCategory(categoryAddReq);
    }

    //calisiyor, her kategoriden ilgili bolumumun id si ile getiriyor
    //sadece kategori id ve isimlerini getiriyor.
    // urunlerin kategorilere getirilmesini simdi yapalim
    @GetMapping("/getcategory")
    public Optional<Object> getCategory(@RequestBody CategoryGetReq categoryGetReq){
return productService.getCategory(categoryGetReq);
    }

    //calsiyor. urune gore urun detaylari cagirilabiliyor
    @GetMapping("/getProdAbout")
    public List<ProductAboutRes> getProdAbout(@RequestBody Products products){
        return productService.getProdAbout(products);
    }
    //EKLEME CALSIIYOR
    @PostMapping("/addProdAbout")
    public ResponseEntity<Response> adProdAbout(@RequestBody ProductAbout productAbout){
        return productService.addProdAbout(productAbout);
    }
    //admin urunlere aciklama ekleyebiliyor, aciklamalari getirdebiliyor,

// bu admin tarafindan, uazilan yorumu inceleyip, onay vermeve onayvermeme nedenlerinin yazilip guncellendigi bir method
    //calisiyor....
    //yorum sayisi ve yildiz ortalamasi ekleniyor
    // ayni yorum birden fazla kaydedilir update edilirse tekrar hesaplamaya girmez.
    @PostMapping("/addcomment")
    public ResponseEntity<Response> addComment(@RequestBody Comments comments){
        return  commentAService.addComment(comments);
    }
    //calisiyor... sadece onay VERILMEYEN yorumlar getiriliyor.
    //YORMLARI ANA SIRKET ONAYLAR. HER SIRKET KENDI YORUMUNU ONAYLASAYDI, OLUMSUZ YORUMLARA IZIN VERMEZDI
    @GetMapping("/getComment")
    public List<CommentRes> getComment(){
        return commentAService.getComments();
    }

    //TEK YORUMU GETIREN METHOD, KONTROL EDILMESI ICIN
    @GetMapping("/getCommetById")
    public CommentRes getCommentById(@RequestBody Comments comments){
        return commentAService.getCommentById(comments);
    }
}

