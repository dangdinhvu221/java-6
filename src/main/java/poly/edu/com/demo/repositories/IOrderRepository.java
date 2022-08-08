package poly.edu.com.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.com.demo.entity.Orders;

public interface IOrderRepository extends JpaRepository<Orders, Long> {
    Orders findTop1ByOrderByIdDesc();
}
