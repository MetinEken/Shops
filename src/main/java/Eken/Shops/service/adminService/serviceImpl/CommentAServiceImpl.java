package Eken.Shops.service.adminService.serviceImpl;

import Eken.Shops.model.Comments;
import Eken.Shops.model.Products;
import Eken.Shops.repository.CommentRepo;
import Eken.Shops.repository.ProductRepo;
import Eken.Shops.response.CommentRes;
import Eken.Shops.response.Response;
import Eken.Shops.service.adminService.CommentAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class CommentAServiceImpl implements CommentAService {
    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ProductRepo productRepo;

    //yapilan kontrol sonrasi yorum onay veriliyor veya red, ret sebebiyle tekrar guncelleniyor
    //calisiyor...
    @Override
    public ResponseEntity<Response> addComment(Comments comments) {
        Response response = new Response();

        try {
            if (comments.isControlled() == true) {
                if (comments.isCount() == false){
                List<Comments> comments1 = commentRepo.getAllCommentsByProduct(comments.getProducts().getId());
                double x = comments.getStar();
              double x1=  comments1.stream().map(n -> n.getStar()).reduce(Double.valueOf(0), (a, b) -> a+b);
                System.out.println("yildizlarin toplami : "+ (x+x1));
                Products products = productRepo.getById(comments.getProducts().getId());
                int y = products.getNumComments() + 1;
                System.out.println("toplam yorum sayisi : "+y);
                double s = (x+x1) / y;
                System.out.println("star ortalamsi : "+s);

                products.setNumComments(products.getNumComments() + 1);
                products.setStar(s);
                productRepo.save(products);
             comments.setCount(true);
             commentRepo.save(comments);
            }
            }
            commentRepo.save(comments);
            response.setSuccess(true);
            response.setMessage("yorum basari ile eklendi, yildiz hesaplamasi yapildi ve eklendi");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage("yorum ekleme sirasinda hata olustu");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    //calisiyor, tum control edilmemis yorumlari getiriyor
    @Override
    public List<CommentRes> getComments() {
        List<Comments> list= commentRepo.getAllCommentsNoControl();
        return list.stream().map(n -> new CommentRes(n)).collect(Collectors.toList());
    }

    @Override
    public CommentRes getCommentById(Comments comments) {
        Comments comments1 = commentRepo.getById(comments.getId());
        CommentRes commentRes = new CommentRes(comments1);
        return commentRes;
    }







}
