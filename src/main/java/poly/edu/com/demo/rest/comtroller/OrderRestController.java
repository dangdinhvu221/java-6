package poly.edu.com.demo.rest.comtroller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.edu.com.demo.entity.Orders;
import poly.edu.com.demo.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
    @Autowired
    private OrderService orderService;

    @PostMapping("{id}/{quantity}")
    public Orders create(@RequestBody JsonNode orderData, @PathVariable("id") Integer id, @PathVariable("quantity") Integer quantity) throws Exception {
        if (orderService.quantityProduct(id) > quantity) {
            throw new Exception();
        }
        return orderService.create(orderData);
    }

    @DeleteMapping("{id}/{quantity}")
    public void update(@PathVariable("id") Integer id, @PathVariable("quantity") Integer quantity) {

        orderService.sellProduct(quantity, id);
    }

    @GetMapping("{id}/{quantity}")
    public void checkQuantity(@PathVariable("id") Integer id, @PathVariable("quantity") Integer quantity) throws Exception {

    }
}
