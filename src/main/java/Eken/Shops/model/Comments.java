package Eken.Shops.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String comment;
    private Date date;
    private String comAntword;
    private double star;
    private boolean approval;
    private String userName;
    private boolean controlled;
    private String cause;
    private boolean count;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Products products;
}
