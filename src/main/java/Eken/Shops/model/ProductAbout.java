package Eken.Shops.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAbout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // burada AUTO yerine yzdigim se.. desteklenmedi bircok hata verdi
    @Column(name = "id", nullable = false)
    private Long id;
    private  String about;
    private String img;

    @JoinColumn(name="productId", nullable=true)
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
   // @JsonIgnore
    Products products;


}
