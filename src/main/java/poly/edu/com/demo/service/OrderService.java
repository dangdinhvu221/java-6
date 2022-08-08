package poly.edu.com.demo.service;


import org.springframework.data.domain.Page;
import poly.edu.com.demo.entity.Orders;
import poly.edu.com.demo.entity.Users;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface OrderService {
    Orders addOrder(Users users, Date created, BigDecimal totalPrice, Long orderStates);

    Orders getOrderDesc();

    Orders addOrders(Orders orders);

    Orders updateOrders(Long id, Long idState);

    List<Orders> getAllOrders();

    Orders getOrders(Long id);

    Orders deleteOrders(Long id);

    void deleteAllOrders(Long[] id);

    Page<Orders> findPaginated(int pageNo, int pageSize);
}
