package poly.edu.com.demo.rest.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.edu.com.demo.entity.Users;
import poly.edu.com.demo.service.UserService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/users")
public class UsersRestController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public Users getOne(@PathVariable(name = "id") Long id) {
        return this.userService.getUser(id);
    }

    @GetMapping("")
    public List<Users> getAll() {
        return this.userService.getAllUsers();
    }

    @GetMapping("admin")
    public List<Users> getALlProductAdmin() {
        return this.userService.getAllUsers();
    }

    @PostMapping("")
    public Users create(@RequestBody Users user) {
        return this.userService.addUsers(user);
    }

    @PutMapping("{id}")
    public Users update(@PathVariable("id") Long id,@RequestBody Users user) {
        return this.userService.update(user);
    }

    @DeleteMapping("{id}")
    public void update(@PathVariable("id") Long id) {
        this.userService.deleteUser(id);
    }
}
