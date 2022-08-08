package poly.edu.com.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.com.demo.entity.EarPhone;
import poly.edu.com.demo.entity.Manufacturer;

import java.util.List;

public interface IEarPhoneRepository extends JpaRepository<EarPhone, Long> {
    List<EarPhone> findByNameLike(String name);
    List<EarPhone> findByManufacturerByManufacturerId(Manufacturer manufacturerByManufacturerId);

}
