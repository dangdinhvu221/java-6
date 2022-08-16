package poly.edu.com.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.edu.com.demo.entity.EarPhone;
import poly.edu.com.demo.entity.Manufacturer;

import java.util.List;

public interface IEarPhoneRepository extends JpaRepository<EarPhone, Long> {
    @Query("select p from EarPhone  p where p.manufacturerByManufacturerId.id=?1")
    List<EarPhone> findByCategoryId(String cid);
    @Query("select p from EarPhone  p where p.quantity > 0")
    List<EarPhone> findAllProduct();
}
