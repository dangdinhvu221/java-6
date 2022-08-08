package poly.edu.com.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.com.demo.entity.Orders;
import poly.edu.com.demo.service.OrderDetailService;
import poly.edu.com.demo.service.OrderService;

@Controller
@RequestMapping("/earPhone/dashAdmin")
public class OrderDetailController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService detailsService;

    @GetMapping("/orderDetails/{id}")
    public String showOrderDetails(ModelMap model,
                                   @PathVariable Long id){
        Orders order = this.orderService.getOrders(id);
        model.addAttribute("listOrderDetails", this.detailsService.findByOrdersByOrdersId(order));
        return "dashAdmin/fragments/orderDetails";
    }
}
