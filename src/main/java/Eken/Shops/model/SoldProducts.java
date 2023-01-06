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
public class SoldProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

   private int piece;
   private double preice;
   private double total;
   private Date date;
   private boolean confirm;
   private String status;
   private String postNumber;
   private double cargo_preice;
   private Long compId;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "products_id")
   @OnDelete(action = OnDeleteAction.CASCADE)
   Products products;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "user_id")
   @OnDelete(action = OnDeleteAction.CASCADE)
   User user;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "transaction_id")
@OnDelete(action = OnDeleteAction.CASCADE)
Transaction transaction;


@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name ="address")
@OnDelete(action = OnDeleteAction.CASCADE)
Address address;

// buraya satiomis urunu kaydetmeden once ilkolarak transactinon tablosuna kaydedilip, transaction_id si alinmalidir. !!!
}
