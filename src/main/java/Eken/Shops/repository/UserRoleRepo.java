package Eken.Shops.repository;

import Eken.Shops.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(Long id);

    UserRole findByUserIdAndRoleId(Long user, Long role);



   @Query(value = "delete from UserRole u where u.id=:id", nativeQuery = true)
    void deleteArg(@Param("id") Long id);

   @Query(value = "delete from UserRole u where u.user_id = :userId and u.role_id = :roleId",
           nativeQuery = true)
void delteRole(@Param("userId")Long userId, @Param("roleId") Long roleId);


//   @Query(value = "select * from Cart c where c.user_id = :userId and c.products_id = :productsId",
//           nativeQuery = true)
//   Cart getCartByUserAndProductId(@Param("userId") Long userId, @Param("productsId") Long productsId);

//    @Modifying
//    @Query("delete from Book b where b.title=:title")
//    void deleteBooks(@Param("title") String title);
}
