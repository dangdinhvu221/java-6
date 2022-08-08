package poly.edu.com.demo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    @RequestMapping("/security/login/form")
    public String form(Model model){
        model.addAttribute("message", "Vui lòng đăng nhập!");
        return "logIn/index";
    }

    @RequestMapping("/security/login/success")
    public String success(Model model){
        model.addAttribute("message", "Đăng nhập thành công!");
        model.addAttribute("login", true);
        return "forward:/security/login/form";
    }

    @RequestMapping("/security/login/error")
    public String error(Model model){
        model.addAttribute("message", "Sai thông tin đăng nhập!");
        return "forward:/security/login/form";
    }

    @RequestMapping("/security/logoff/success")
    public String logoff(Model model){
        model.addAttribute("message", "Đăng xuất thành công!");
        return "forward:/security/login/form";
    }

    @RequestMapping("/security/unauthoried")
    public String unauthoried(Model model){
        model.addAttribute("message", "Không có quyền truy xuất!");
        return "forward:/security/login/form";
    }
}
