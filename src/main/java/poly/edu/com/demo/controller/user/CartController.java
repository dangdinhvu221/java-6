package poly.edu.com.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.com.demo.entity.CartDetails;
import poly.edu.com.demo.service.CartService;
import poly.edu.com.demo.service.EarPhoneService;

@Controller
@RequestMapping("/earPhone")
public class CartController {
    @Autowired
    private EarPhoneService earPhoneService;
    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String viewCart(Model model){
        return "homePage/fragments/cart";
    }
}
