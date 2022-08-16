package poly.edu.com.demo.service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import poly.edu.com.demo.entity.Manufacturer;
import poly.edu.com.demo.entity.OrderDetails;
import poly.edu.com.demo.entity.Orders;
import poly.edu.com.demo.entity.Users;
import poly.edu.com.demo.repositories.IOrderDetailRepository;
import poly.edu.com.demo.repositories.IOrderRepository;
import poly.edu.com.demo.repositories.IUserRepository;
import poly.edu.com.demo.service.OrderService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private IOrderDetailRepository detailRepository;

    @Override
    public Orders addOrder(Users users, Date created, BigDecimal totalPrice, Long orderStates) {
        return null;
    }

    @Override
    public Orders getOrderDesc() {
        return null;
    }

    @Override
    public Orders addOrders(Orders orders) {
        return this.orderRepository.save(orders);
    }

    @Override
    public Orders updateOrders(Orders orders) {
        Long id = orders.getId();
        if (id != null) {
            Optional<Orders> update = this.orderRepository.findById(id);
            if (update.isPresent()) {
                orders.setId(id);
                return this.orderRepository.save(orders);
            }
        }
        return null;
    }

    @Override
    public List<Orders> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Orders getOrders(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Orders deleteOrders(Long id) {
        if (id != null) {
            Optional<Orders> order = this.orderRepository.findById(id);
            if (order.isPresent()) {
                this.orderRepository.deleteById(id);
                return order.get();
            }
        }
        return null;
    }

    @Override
    public Orders create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        Orders order = mapper.convertValue(orderData, Orders.class);
        this.orderRepository.save(order);
        TypeReference<List<OrderDetails>> type = new TypeReference<List<OrderDetails>>() {
        };
        List<OrderDetails> details = mapper.convertValue(orderData.get("orderDetails"), type)
                .stream().peek(d -> d.setOrdersByOrdersId(order)).collect(Collectors.toList());
        this.detailRepository.saveAll(details);
        return order;
    }

    @Override
    public int quantityProduct(Long id) {
        return this.detailRepository.quantityProduct(id);
    }

    @Override
    public void sellProduct(Integer quantity, Long id) {
        this.detailRepository.sellProduct(quantity, id);
    }

    @Override
    public List<Orders> findByUsername(String username) {
        return orderRepository.findByUsername(username);
    }
}
