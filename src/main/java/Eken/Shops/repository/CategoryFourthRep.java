package Eken.Shops.repository;

import Eken.Shops.model.CategoryFourth;
import Eken.Shops.model.CategorySecond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryFourthRep extends JpaRepository<CategoryFourth, Long> {
    @Query(value = "select * from Category_fourth c where c.ctg_3 = :id" ,  nativeQuery = true)
    List<CategoryFourth> getByCtg(@Param("id") Long id);
}
