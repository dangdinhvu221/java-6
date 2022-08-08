package poly.edu.com.demo.service;


import org.springframework.data.domain.Page;
import poly.edu.com.demo.entity.OrderDetails;
import poly.edu.com.demo.entity.Orders;

import java.math.BigDecimal;
import java.util.List;

public interface OrderDetailService {
    OrderDetails addOrderDetails(OrderDetails orderDetails);

    OrderDetails updateOrderDetails(OrderDetails orderDetails);

    List<OrderDetails> getAllOrderDetails();

    List<OrderDetails> findByOrdersByOrdersId(Orders order);

    OrderDetails getOrderDetails(Long id);

    OrderDetails deleteOrderDetails(Long id);

    void deleteAllOrderDetails(Long[] id);

    Page<OrderDetails> findPaginated(int pageNo, int pageSize);

    OrderDetails addOrderDetails(Long earPhoneId, Long orderId, BigDecimal price, Integer quantity);

}
