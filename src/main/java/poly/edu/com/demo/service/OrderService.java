package poly.edu.com.demo.service;


import com.fasterxml.jackson.databind.JsonNode;
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

    Orders updateOrders(Orders orders);

    List<Orders> getAllOrders();

    Orders getOrders(Long id);

    Orders deleteOrders(Long id);

    Orders create(JsonNode orderData);

    int quantityProduct(Long id);

    void sellProduct(Integer quantity, Long id);

    List<Orders> findByUsername(String username);
}
