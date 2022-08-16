package poly.edu.com.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import poly.edu.com.demo.entity.Orders;
import poly.edu.com.demo.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrdersController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/checkout")
    public String checkout() {
        return "homePage/fragments/checkout";
    }

    @RequestMapping("/history")
    public String list(ModelMap model, HttpServletRequest request) {
        String username = request.getRemoteUser();
        List<Orders> list = orderService.findByUsername(username);
        model.addAttribute("orders",list);
        return "homePage/fragments/historyOrder";
    }

    @RequestMapping("/order/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        model.addAttribute("order", orderService.getOrders(id));
        return "homePage/fragments/detail";
    }
}
