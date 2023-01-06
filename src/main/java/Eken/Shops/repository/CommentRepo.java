package Eken.Shops.repository;

import Eken.Shops.model.Comments;
import Eken.Shops.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comments, Long> {

    @Query(value = "select * from Comments c where c.products_id =:id and c.approval = true", nativeQuery = true)
    List<Comments> getAllCommentsByProduct(@Param("id") Long id);

    @Query(value = "select * from Comments c where  c.controlled = false", nativeQuery = true)
    List<Comments> getAllCommentsNoControl();

    List<Comments> findAllByProducts(Products products);
}
