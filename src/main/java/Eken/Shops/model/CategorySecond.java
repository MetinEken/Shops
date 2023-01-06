package Eken.Shops.model;


import Eken.Shops.model.CategoryMain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
public class CategorySecond {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;


   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "ctgm")
   @OnDelete(action = OnDeleteAction.CASCADE)
   @JsonIgnore
   CategoryMain categoryMain;


}
