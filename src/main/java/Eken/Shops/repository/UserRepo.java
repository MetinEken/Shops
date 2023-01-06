package Eken.Shops.repository;

import Eken.Shops.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Long> {
    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);

    User findByEmail(String email);

    Optional<User> findById(Long userId);
@Query(value ="select * from user",nativeQuery = true)
    List<User> getAllUser();

    List<User> findByName(String name);

   // User findAll();
}
