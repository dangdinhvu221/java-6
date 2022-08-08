package poly.edu.com.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.com.demo.entity.Users;
import poly.edu.com.demo.service.OrderDetailService;
import poly.edu.com.demo.service.OrderService;
import poly.edu.com.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("/earPhone")
public class HistoryOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService detailsService;
    @Autowired
    private UserService userService;

    @GetMapping("/history")
    public String historyOrder(Model model, Principal principal) {
        Users user = userService.getUsersByUsername(principal.getName());
        if (user != null) {
            model.addAttribute("userSession", user);
            model.addAttribute("listOrders", this.orderService.getAllOrders());
            model.addAttribute("listOrderDetails", this.detailsService.getAllOrderDetails());
        } else {
            return "redirect:/earPhone/homePage";
        }

        return "homePage/fragments/historyOrder";

    }

}
