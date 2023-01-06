package Eken.Shops.repository;

import Eken.Shops.model.SoldProducts;
import Eken.Shops.response.SoldProductRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SoldProdRepo extends JpaRepository<SoldProducts, Long> {

    @Query(value = "select * from sold_products s where s.comp_id = :id and confirm =false", nativeQuery = true)
    List<SoldProducts> getAllByCompId(@Param("id")Long id);


//burada genel bir sorgu yazdik, sirket islemin statusune gore arama yapabilecek. onay bolumu kaldirilabilir
List<SoldProducts> findByCompIdAndStatus(Long id, String Status);
}
