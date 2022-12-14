package poly.edu.com.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import poly.edu.com.demo.entity.EarPhone;
import poly.edu.com.demo.entity.OrderDetails;
import poly.edu.com.demo.entity.Orders;
import poly.edu.com.demo.repositories.IEarPhoneRepository;
import poly.edu.com.demo.repositories.IOrderDetailRepository;
import poly.edu.com.demo.repositories.IOrderRepository;
import poly.edu.com.demo.service.OrderDetailService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private IOrderDetailRepository detailRepository;

    @Autowired
    private IEarPhoneRepository earPhoneRepository;

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public OrderDetails addOrderDetails(OrderDetails orderDetails) {
        return this.detailRepository.save(orderDetails);
    }

    @Override
    public OrderDetails updateOrderDetails(OrderDetails orderDetails) {
        Long id = orderDetails.getId();
        if(id != null) {
            Optional<OrderDetails> oD = this.detailRepository.findById(id);
            if(oD.isPresent()){
                orderDetails.setId(id);
                this.detailRepository.save(orderDetails);
            }
        }
        return null;
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return this.detailRepository.findAll();
    }

    @Override
    public List<OrderDetails> findByOrdersByOrdersId(Orders order) {

        return this.detailRepository.findByOrdersByOrdersId(order);
    }

    @Override
    public OrderDetails getOrderDetails(Long id) {
        return this.detailRepository.findById(id).get();
    }

    @Override
    public OrderDetails deleteOrderDetails(Long id) {
        if (id != null) {
            Optional<OrderDetails> oD = this.detailRepository.findById(id);
            if (oD.isPresent()) {
                this.detailRepository.deleteById(id);
                return oD.get();
            }
        }
        return null;
    }

    @Override
    public void deleteAllOrderDetails(Long[] id) {
        this.detailRepository.deleteAllByIdInBatch(Arrays.asList(id));
    }

    @Override
    public Page<OrderDetails> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.detailRepository.findAll(pageable);
    }

    @Override
    public OrderDetails addOrderDetails(Long earPhoneId, Long orderId, BigDecimal price, Integer quantity) {
        OrderDetails orderDetails = new OrderDetails();
        EarPhone earPhone = this.earPhoneRepository.findById(earPhoneId).get();
        earPhone.setQuantity(earPhone.getQuantity() - quantity);
        Orders orders = this.orderRepository.findById(orderId).get();
        orderDetails.setEarPhoneByEarPhoneId(earPhone);
        orderDetails.setOrdersByOrdersId(orders);
        orderDetails.setPrice(price);
        orderDetails.setQuantity(quantity);
        return this.detailRepository.save(orderDetails);
    }
}
