package poly.edu.com.demo.controller.user;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.com.demo.entity.Orders;
import poly.edu.com.demo.service.*;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class CheckoutController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/checkout")
    public String checkout(Model model) {
        return "homePage/fragments/checkout";
    }

    @GetMapping("/list")
    public String list(Model model, HttpServletRequest request) {
        String username = request.getRemoteUser();
        model.addAttribute("order", orderService.findByUsername(username));
        return "order/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        model.addAttribute("order", orderService.getOrders(id));

        return "homePage/fragments/detail";
    }
}
