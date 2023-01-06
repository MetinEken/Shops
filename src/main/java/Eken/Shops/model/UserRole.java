package Eken.Shops.model;

import Eken.Shops.model.Role;
import Eken.Shops.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  Role role;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }
    public UserRole(Long id ,User user, Role role) {
        this.id =id;
        this.user = user;
        this.role = role;
    }
}
