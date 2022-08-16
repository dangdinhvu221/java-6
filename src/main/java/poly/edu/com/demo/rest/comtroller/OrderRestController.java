package poly.edu.com.demo.rest.comtroller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.edu.com.demo.entity.Orders;
import poly.edu.com.demo.entity.Users;
import poly.edu.com.demo.service.OrderService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
    @Autowired
    private OrderService orderService;

    @GetMapping("{id}")
    public Orders getOne(@PathVariable(name = "id") Long id) {
        return this.orderService.getOrders(id);
    }

    @GetMapping("admin")
    public List<Orders> getAll() {
        return this.orderService.getAllOrders();
    }

    @PostMapping("{id}/{quantity}")
    public Orders create(@RequestBody JsonNode orderData, @PathVariable("id") Long id, @PathVariable("quantity") Integer quantity) throws Exception {
        if (orderService.quantityProduct(id) > quantity) {
            throw new Exception();
        }
        return orderService.create(orderData);
    }

    @PutMapping("{id}/{quantity}")
    public void update(@PathVariable("id") Long id, @PathVariable("quantity") Integer quantity) {
        orderService.sellProduct(quantity, id);
    }

    @DeleteMapping("{id}/{quantity}")
    public void delete(@PathVariable("id") Long id, @PathVariable("quantity") Integer quantity) {
        orderService.sellProduct(quantity, id);
    }

    @GetMapping("{id}/{quantity}")
    public void checkQuantity(@PathVariable("id") Integer id, @PathVariable("quantity") Integer quantity) throws Exception {

    }
}
