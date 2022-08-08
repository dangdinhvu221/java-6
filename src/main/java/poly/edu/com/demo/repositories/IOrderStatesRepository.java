package poly.edu.com.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.com.demo.entity.OrderStates;

public interface IOrderStatesRepository extends JpaRepository<OrderStates, Long> {
}
