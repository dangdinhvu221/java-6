package poly.edu.com.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.com.demo.service.EarPhoneService;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/earPhone")
public class HomePageController {
    @Autowired
    private EarPhoneService earPhoneService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/homePage")
    private String homePage(Model model) {
        model.addAttribute("EDIT", "/earPhone/earPhoneDetails/");
        model.addAttribute("listEarPhone", this.earPhoneService.getAllEarPhones());
        return "homePage/layouts/indexHomePage";
    }

    @GetMapping("/earPhoneDetails/{id}")
    private String earPhoneDetail(Model model, @PathVariable Long id
    ) {
        model.addAttribute("earPhone", this.earPhoneService.getEarPhone(id));
        return "homePage/fragments/product-detail";
    }

    @GetMapping("/logInForm")
    private String logIn(Model model) {
        return "LogIn/index";
    }
}
