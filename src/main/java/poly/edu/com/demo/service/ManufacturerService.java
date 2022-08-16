package poly.edu.com.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.com.demo.entity.Manufacturer;

import java.util.List;
public interface ManufacturerService {
    Manufacturer addManufacturer(Manufacturer manufacturer);

    Manufacturer updateManufacturer(Manufacturer manufacturer);

    List<Manufacturer> getAllManufacturer();

    Manufacturer getManufacturer(Long id);

    Manufacturer deleteManufacturer(Long id);

}
