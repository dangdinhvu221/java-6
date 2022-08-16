package poly.edu.com.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.com.demo.entity.Users;
import poly.edu.com.demo.entity.typeEnum.TypeGender;
import poly.edu.com.demo.entity.typeEnum.TypeRole;
import poly.edu.com.demo.entity.typeEnum.TypeStatus;
import poly.edu.com.demo.repositories.IUserRepository;
import poly.edu.com.demo.service.UserService;

import java.io.IOException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Optional<Users> findByID(String id) {
        return this.userRepository.findByUsername(id);
    }

    @Override
    public Users addUsers(Users user) {
        return this.userRepository.save(user);
    }

    @Override
    public Users update(Users user) {

        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return this.userRepository.findByTypeStatus(TypeStatus.ONLINE);
    }

    @Override
    public List<Users> getUsersByName(String name) {
        return this.userRepository.findByFullNameLike("%" + name + "%");
    }

    @Override
    public Users getUsersByUsername(String username) {
        return this.userRepository.findByUsernameLike(username);
    }


    @Override
    public Users getUser(Long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public Users deleteUser(Long id) {
        if (id != null) {
            Optional<Users> users = userRepository.findById(id);
            if (users.isPresent()) {
                userRepository.deleteById(id);
                return users.get();
            }
        }
        return null;
    }

    @Override
    public void deleteAllUsers(Long[] id) {
        if (id != null) {
            this.userRepository.deleteAllByIdInBatch(Arrays.asList(id));
        }
    }
}
