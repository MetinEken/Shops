package Eken.Shops.repository;

import Eken.Shops.model.ProductsAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdAdminRepo extends JpaRepository<ProductsAdmin, Long> {
}
