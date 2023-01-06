package Eken.Shops.repository;

import Eken.Shops.model.CategorySecond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorySecondRep extends JpaRepository<CategorySecond, Long> {

    @Query(value = "select * from Category_second c where c.ctgm = :id" ,  nativeQuery = true)
    List<CategorySecond> getByCtgm(@Param("id") Long id);
}
