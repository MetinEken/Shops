package Eken.Shops.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String userName;

    private String email;

    private String name;
    private  String lastName;

    private String password;
private Date date;
    private String provider=null;
    private String loginDates; // user hergiris yaptiginda giris tarihini kaydetmek icin olusturuldu. nasil kullanabiliriz.


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> userRole = new HashSet<>();

public User(){}
    public User(String userName, String name, String email, String lastName, String password) {
        this.userName=userName;
        this.name= name;
        this.email =email;
        this.lastName=lastName;
        this.password=password;

    }
    public User(Long id, String userName, String email, String name, String lastName, String password, String provider, String loginDates, Date date, Set<UserRole> userRole) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.provider = provider;
        this.loginDates = loginDates;
        this.date =date;
        this.userRole = userRole;
    }
    public User(String userName, String email, String name, String lastName, String password, String provider, String loginDates, Set<UserRole> userRole) {
         this.userName = userName;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.provider = provider;
        this.loginDates = loginDates;
        this.userRole = userRole;
    }
}