package Eken.Shops.model;

import Eken.Shops.model.CategorySecond;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class CategoryThird {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

  private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ctg_2")
    @OnDelete(action = OnDeleteAction.CASCADE)
            @JsonIgnore
    CategorySecond categorySecond;
}
