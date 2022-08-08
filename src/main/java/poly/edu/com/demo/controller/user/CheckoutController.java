package poly.edu.com.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.com.demo.entity.CartDetails;
import poly.edu.com.demo.entity.Users;
import poly.edu.com.demo.service.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class CheckoutController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService detailsService;
    @Autowired
    private EarPhoneService earPhoneService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @GetMapping("/checkout")
    public String showOrder(Model model) {
        model.addAttribute("listOrders", orderService.getAllOrders());
        model.addAttribute("listOrdersDetails", detailsService.getAllOrderDetails());
        int total = 0;
        int count = 0;
        for (CartDetails c : cartService.getCart().getCartDetails()) {
            total += (c.getQuantity() * Integer.parseInt(String.valueOf(c.getPrice())));
            count++;
        }
        model.addAttribute("cartCount", count);
        model.addAttribute("cartDetails", cartService.getCart().getCartDetails());
        model.addAttribute("totalPrice", total);
        model.addAttribute("BUY_ALL", "/shop/buy");
        model.addAttribute("BUY_ID", "/shop/buy/{id}");
        return "homePage/fragments/checkout";
    }
}
