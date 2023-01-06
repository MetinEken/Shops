package Eken.Shops.model;

import Eken.Shops.model.Address;
import Eken.Shops.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String payMethod;

    private  double total;
    private double lastTotal;
    private String payBack;

    private Date date;

    private boolean isconfirm;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "address_id")
@OnDelete(action = OnDeleteAction.CASCADE)
Address address;

    public Transaction(String payMethod, double total, Date date, User user, Address address) {
    }
}
