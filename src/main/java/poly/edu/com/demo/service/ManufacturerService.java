package poly.edu.com.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.com.demo.entity.Manufacturer;

import java.util.List;
public interface ManufacturerService {
    Manufacturer addManufacturer(Manufacturer manufacturer, MultipartFile image);

    Manufacturer updateManufacturer(Manufacturer manufacturer, MultipartFile file);

    List<Manufacturer> getAllManufacturer();

    List<Manufacturer> getManufacturerByName(String name);

    Manufacturer getManufacturer(Long id);

    Manufacturer deleteManufacturer(Long id);

    void deleteAllManufacturer(Long[] id);

    Page<Manufacturer> findPaginated(int pageNo, int pageSize);
}
