package poly.edu.com.demo.rest.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.edu.com.demo.entity.EarPhone;
import poly.edu.com.demo.service.EarPhoneService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/earPhones")
public class EarPhoneRestController {
    @Autowired
    private EarPhoneService earPhoneService;

    @GetMapping("{id}")
    public EarPhone getOne(@PathVariable(name = "id") Long id) {
        return earPhoneService.getEarPhone(id);
    }

    @GetMapping()
    public List<EarPhone> getAll() {
        return earPhoneService.getAllEarPhones();
    }

    @GetMapping("admin")
    public List<EarPhone> getALlProductAdmin() {
        return earPhoneService.findAllProductAdmin();
    }

    @PostMapping
    public EarPhone create(@RequestBody EarPhone product) {
        return earPhoneService.addEarPhone(product);
    }

    @PutMapping("{id}")
    public EarPhone update(@PathVariable("id") Long id, @RequestBody EarPhone product) {
        return earPhoneService.updateEarPhone(product);
    }

    @DeleteMapping("{id}")
    public void update(@PathVariable("id") Long id) {
        earPhoneService.deleteEarPhone(id);
    }
}
