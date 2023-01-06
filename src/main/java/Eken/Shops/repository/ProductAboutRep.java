package Eken.Shops.repository;

import Eken.Shops.model.ProductAbout;
import Eken.Shops.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductAboutRep extends JpaRepository<ProductAbout, Long> {
//ilk basta (Long id) ile arattigim asagidaki sorguyu hata verdi, iliskili tabloda id ile bagli column u sev=cerek aratmak icin
    // Long id ile degil colum hangi tabloyu temsil ediyorsa o tablo ismi ile aratmak gerekiyor
    // class isminin tamamini yazmak gerekiyor
    List<ProductAbout> findByProducts(Products id);
//yukaridaki sorgunun Query hali, calisiyor ....
//    @Query (value = "select * from Product_about p where p.product_id = :id", nativeQuery = true)
//    List<ProductAbout> getAllAboutByProd(@Param("id") Long id);


}
