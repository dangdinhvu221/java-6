package poly.edu.com.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import poly.edu.com.demo.entity.OrderDetails;
import poly.edu.com.demo.entity.Orders;

import java.util.List;

public interface IOrderDetailRepository extends JpaRepository<OrderDetails, Long> {
    List<OrderDetails> findByOrdersByOrdersId(Orders ordersByOrdersId);

    @Query(value = "select count (*) from ear_phone where id = ?", nativeQuery = true)

    Integer quantityProduct(Long id);

    @Transactional
    @Modifying
    @Query(value = "update EarPhone p set p.quantity = p.quantity - ?1 where p.id = ?2")
    void sellProduct(Integer quantity, Long id);
}
