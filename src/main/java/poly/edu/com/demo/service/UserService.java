package poly.edu.com.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.com.demo.entity.Users;
import poly.edu.com.demo.entity.typeEnum.TypeGender;
import poly.edu.com.demo.entity.typeEnum.TypeRole;
import poly.edu.com.demo.entity.typeEnum.TypeStatus;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface UserService {
    Optional<Users> findByID(String id);

    Users addUsers(Users user);

    Users update(Users user);

    List<Users> getAllUsers();

    List<Users> getUsersByName(String name);

    Users getUsersByUsername(String username);

    Users getUser(Long id);

    Users deleteUser(Long id);

    void deleteAllUsers(Long[] id);
}
