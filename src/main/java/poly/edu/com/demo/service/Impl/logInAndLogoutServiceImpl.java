package poly.edu.com.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.com.demo.entity.Users;
import poly.edu.com.demo.entity.typeEnum.TypeRole;
import poly.edu.com.demo.repositories.IUserRepository;
import poly.edu.com.demo.service.AuthenService;

import javax.servlet.http.HttpServletRequest;

@Service
public class logInAndLogoutServiceImpl implements AuthenService {
    private static final String ATT_USER_LOGIN = "login";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private IUserRepository usersRepository;

    @Override
    public Users login(String username, String pass) {
        System.out.println(usersRepository.findByUsernameAndPassword(username,pass).getTypeRole().toString());
        return usersRepository.findByUsernameAndPassword(username,pass);
    }

    @Override
    public boolean isAdmin() {
        Users user = getUser();
        return user.getTypeRole().getValue().equals(TypeRole.ADMIN.getValue());
    }

    @Override
    public void logout() {
        request.getSession().removeAttribute(ATT_USER_LOGIN);
    }

    @Override
    public Users getUser() {
        Users user = (Users) request.getSession().getAttribute(ATT_USER_LOGIN);
        if (user == null) {
            user = new Users();
            request.getSession().setAttribute(ATT_USER_LOGIN, user);
        }
        return user;
    }
}
