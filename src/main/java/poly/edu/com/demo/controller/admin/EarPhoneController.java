package poly.edu.com.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.com.demo.entity.EarPhone;
import poly.edu.com.demo.service.EarPhoneService;

import java.util.List;
import java.util.Optional;

@Controller
public class EarPhoneController {
    @Autowired
    EarPhoneService earPhoneService;

    @RequestMapping("/earPhone/list")
    public String list(Model model, @RequestParam("cid") Optional<String> cid){
        if(cid.isPresent()){
            List<EarPhone> list =earPhoneService.findByCategoryId(cid.get());
            model.addAttribute("items", list);
        }else{
            List<EarPhone> list =earPhoneService.getAllEarPhones();
            model.addAttribute("items", list);
        }
        return "product/list";
    }

    @RequestMapping("/earPhone/detail/{id}")
    public String detail(Model model, @PathVariable(name = "id") Long id){
        EarPhone item =earPhoneService.getEarPhone(id);
        model.addAttribute("item", item);
        return "product/detail";
    }
}
