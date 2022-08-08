package poly.edu.com.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.com.demo.entity.Manufacturer;

import java.util.List;

public interface IManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    List<Manufacturer> findByNameManufacturerLike(String nameManufacturer);
}
