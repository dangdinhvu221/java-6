package poly.edu.com.demo.service;


import poly.edu.com.demo.entity.Users;

public interface AuthenService {
    Users login(String username, String pass);
    boolean isAdmin();
    void logout();
    Users getUser();
}
