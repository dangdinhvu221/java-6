package poly.edu.com.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.com.demo.entity.Orders;
import poly.edu.com.demo.service.OrderService;

@Controller
@RequestMapping("/earPhone")
public class SuccessOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/received/{id}")
    public String successOrder(@PathVariable Long id, ModelMap model){
        Orders orders = this.orderService.getOrders(id);
        if(orders.getOderStatesByOderStatesId().getId() == 4){
            this.orderService.updateOrders(id, 3L);
        }
        return "redirect:/earPhone/history";
    }
}
