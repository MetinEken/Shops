package Eken.Shops.repository;

import Eken.Shops.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepo extends JpaRepository<Cart, Long> {

    @Query(value = "select * from Cart c where c.user_id = :userId and c.products_id = :productsId",
            nativeQuery = true)
    Cart getCartByUserAndProductId(@Param("userId") Long userId, @Param("productsId") Long productsId);
}
