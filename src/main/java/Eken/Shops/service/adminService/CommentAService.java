package Eken.Shops.service.adminService;

import Eken.Shops.model.Comments;
import Eken.Shops.response.CommentRes;
import Eken.Shops.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CommentAService {
    ResponseEntity<Response> addComment(Comments comments);

    List<CommentRes> getComments();


    CommentRes getCommentById(Comments comments);
}
