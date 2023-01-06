package Eken.Shops.repository;

import Eken.Shops.model.CategorySecond;
import Eken.Shops.model.CategoryThird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryThirdRep extends JpaRepository<CategoryThird, Long> {
    @Query(value = "select * from Category_third c where c.ctg_2 = :id" ,  nativeQuery = true)
    List<CategoryThird> getByCtg(@Param("id") Long id);
}
