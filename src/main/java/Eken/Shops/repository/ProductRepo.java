package Eken.Shops.repository;

import Eken.Shops.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Products, Long> {

    //categoriye gore tum urunleri getirecegiz. asagidaki kod calismadi, 2 parametreyi alip yazdiramadik
    @Query(value = "select * from Products p where p.:ctg = :id",nativeQuery = true)
    List<Products> getAllByCtg(@Param("ctg") String ctg, @Param("id") Long id);

//    //    @Query (value = "select * from Product_about p where p.product_id = :id", nativeQuery = true)
////    List<ProductAbout> getAllAboutByProd(@Param("id") Long id);

//    @Query(value = "select * from Products p where p.ctgm = :id",nativeQuery = true)
//    List<Products> getAllByCtgm(@Param("id") Long id);


    //sorguda isShow faalse olanlari getiriyor, normalde true olanlar getirilmesi gerekiyor
    @Query(value = "select * from Products p where p.ctgm = :id and p.is_show = false",nativeQuery = true)
    List<Products> getAllByCtgm(@Param("id") Long id);

    @Query(value = "select * from Products p where p.ctg2 = :id",nativeQuery = true)
    List<Products> getAllByCtg2(@Param("id") Long id);

    @Query(value = "select * from Products p where p.ctg3 = :id",nativeQuery = true)
    List<Products> getAllByCtg3(@Param("id") Long id);

    @Query(value = "select * from Products p where p.ctg4 = :id",nativeQuery = true)
    List<Products> getAllByCtg4(@Param("id") Long id);

    }
