package poly.edu.com.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class dashAdminController {

    @RequestMapping({"/admin", "/admin/home/index", "/"})
    public String admin(){
        return "redirect:/assets/admin/indexAdmin.html";

    }

    @RequestMapping("/earPhone/dashAdmin/charts")
    private String chart() {
        return "dashAdmin/fragments/chart";
    }



}
