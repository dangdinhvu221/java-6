package poly.edu.com.demo.rest.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.com.demo.entity.EarPhone;
import poly.edu.com.demo.entity.Manufacturer;
import poly.edu.com.demo.service.ManufacturerService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/manufacturer")
public class ManufacturerRestController {
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("{id}")
    public Manufacturer getOne(@PathVariable(name = "id") Long id) {
        return this.manufacturerService.getManufacturer(id);
    }

    @GetMapping("")
    public List<Manufacturer> getAll() {
        return this.manufacturerService.getAllManufacturer();
    }

    @GetMapping("admin")
    public List<Manufacturer> getALlProductAdmin() {
        return this.manufacturerService.getAllManufacturer();
    }

    @PostMapping
    public Manufacturer create(@RequestBody Manufacturer manufacturer) {
        return this.manufacturerService.addManufacturer(manufacturer);
    }

    @PutMapping("{id}")
    public Manufacturer update(@PathVariable("id") Long id,@RequestBody Manufacturer manufacturer) {
        return this.manufacturerService.updateManufacturer(manufacturer);
    }

    @DeleteMapping("{id}")
    public void update(@PathVariable("id") Long id) {
        this.manufacturerService.deleteManufacturer(id);
    }
}
