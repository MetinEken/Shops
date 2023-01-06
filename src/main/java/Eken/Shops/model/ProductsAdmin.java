package Eken.Shops.model;

import Eken.Shops.model.Products;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ProductsAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private double buyPrice;
    private double soldPrice;

@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "products_id")
@OnDelete(action = OnDeleteAction.CASCADE)
Products products;

}
