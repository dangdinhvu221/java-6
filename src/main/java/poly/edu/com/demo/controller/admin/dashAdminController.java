package poly.edu.com.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/earPhone/dashAdmin/")
public class dashAdminController {

    @GetMapping("/home")
    private String homeAdmin() {
        return "dashAdmin/layouts/indexAdmin";
    }

    @GetMapping("/charts")
    private String chart() {
        return "dashAdmin/fragments/chart";
    }



}
