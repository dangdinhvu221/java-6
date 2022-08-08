package poly.edu.com.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.com.demo.entity.OrderDetails;
import poly.edu.com.demo.entity.Orders;

import java.util.List;

public interface IOrderDetailRepository extends JpaRepository<OrderDetails, Long> {
    List<OrderDetails> findByOrdersByOrdersId(Orders ordersByOrdersId);
}
