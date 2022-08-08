package poly.edu.com.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.com.demo.entity.Users;
import poly.edu.com.demo.entity.typeEnum.TypeStatus;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<Users, Long> {
    default List<Users> findByFullNameLike(String fullName) {
        return null;
    }

    List<Users> findByTypeStatus(TypeStatus typeStatus);
    Optional<Users> findByUsername(String username);
    Users findByUsernameAndPassword(String username, String password);

    Users findByUsernameLike(String username);

}
