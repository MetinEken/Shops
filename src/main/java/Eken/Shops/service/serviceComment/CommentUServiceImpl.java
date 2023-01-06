package Eken.Shops.service.serviceComment;

import Eken.Shops.model.Comments;
import Eken.Shops.model.Products;
import Eken.Shops.repository.CommentRepo;
import Eken.Shops.response.CommentRes;
import Eken.Shops.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentUServiceImpl implements CommentService{
    @Autowired
    CommentRepo commentRepo;
    @Override
    public ResponseEntity<Response> addComment(Comments comments) {
        Response response = new Response();
        Date date = new Date();
        try{
            comments.setDate(date);
            commentRepo.save(comments);
            response.setMessage("Yorumunuz basariile eklenmistir, incelemenin ardindan size e-mail ile" +
                    "bilgi verilecektir.");
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.setMessage("Yorumunuz eklenme asamasinda bir hata olustu, lutfen tekrar dendeyiniz...");
            response.setSuccess(false);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    @Override
    public List<CommentRes> getComments(Products products) {
        List<Comments> list= commentRepo.getAllCommentsByProduct(products.getId());
        return list.stream().map(n -> new CommentRes(n)).collect(Collectors.toList());
    }
}
