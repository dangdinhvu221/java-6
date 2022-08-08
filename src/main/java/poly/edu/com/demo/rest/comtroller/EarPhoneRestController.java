package poly.edu.com.demo.rest.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.edu.com.demo.entity.EarPhone;
import poly.edu.com.demo.service.EarPhoneService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/earPhones")
public class EarPhoneRestController {
    @Autowired
    private EarPhoneService earPhoneService;

    @GetMapping("/{id}")
    public EarPhone getOne(@PathVariable("id") Long id){
        return earPhoneService.getEarPhone(id);
    }
}
