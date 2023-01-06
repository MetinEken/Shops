package Eken.Shops.repository;

import Eken.Shops.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TransacRepo extends JpaRepository<Transaction, Long> {
@Query(value = "select * from Transaction t where t.user_id = :userId and t.date = :date", nativeQuery = true)
    Transaction getLastSave(@Param("userId")Long userId, @Param("date") Date date);

    @Query(value = "select * from Transaction t where t.user_id = :userId", nativeQuery = true)
    List<Transaction> getByUserId(@Param("userId")Long userId);


}
