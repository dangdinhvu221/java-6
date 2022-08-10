package poly.edu.com.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.edu.com.demo.entity.Orders;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT o FROM Orders o WHERE o.usersByUserId.username =?1")
    List<Orders> findByUsername(String username);
}
