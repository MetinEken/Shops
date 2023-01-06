package Eken.Shops.response;

import Eken.Shops.model.Comments;
import lombok.Data;

import java.util.Date;
@Data
public class CommentRes {
    private Long id;
    private String title;

    private String comment;
    private Date date;
    private String comAntword;
    private double star;
    private String userName;
    private boolean controlled;
    private String cause;
    private Long userId;
    private Long productId;

    public CommentRes(Comments entity){
        this.id= entity.getId();
        this.title=entity.getTitle();
        this.comment=entity.getComment();
        this.date=entity.getDate();
        this.comAntword=entity.getComAntword();
        this.star= entity.getStar();
        this.userName=entity.getUserName();
        this.controlled= entity.isControlled();
        this.cause=entity.getCause();
        this.userId=entity.getUser().getId();
        this.productId=entity.getProducts().getId();
    }
}
