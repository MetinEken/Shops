package Eken.Shops.service.serviceComment;

import Eken.Shops.model.Comments;
import Eken.Shops.model.Products;
import Eken.Shops.response.CommentRes;
import Eken.Shops.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    ResponseEntity<Response> addComment(Comments comments);

    List<CommentRes> getComments(Products products);
}
