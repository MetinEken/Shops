package Eken.Shops.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int piece;

    private double preice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Products products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    public Cart(int piece, double preice, Products products, User user) {
        this.piece = piece;
        this.preice = preice;
        this.products = products;
        this.user = user;
    }



    public Cart(int piece, double preice) {
    }
}
