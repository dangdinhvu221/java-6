package poly.edu.com.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.com.demo.entity.Manufacturer;
import poly.edu.com.demo.repositories.IManufacturerRepository;
import poly.edu.com.demo.service.ManufacturerService;

import java.util.List;
import java.util.Optional;


@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private IManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer addManufacturer(Manufacturer manufacturer) {
        manufacturer.setId(null);
        return this.manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        Long id = manufacturer.getId();
        if (id != null) {
            Optional<Manufacturer> updatedManufacturer = this.manufacturerRepository.findById(id);
            if (updatedManufacturer.isPresent()) {
                manufacturer.setId(id);
                return this.manufacturerRepository.save(manufacturer);
            }
        }
        return null;
    }

    @Override
    public List<Manufacturer> getAllManufacturer() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer getManufacturer(Long id) {
        return this.manufacturerRepository.findById(id).get();
    }

    @Override
    public Manufacturer deleteManufacturer(Long id) {
        if (id != null) {
            Optional<Manufacturer> manufacturer = this.manufacturerRepository.findById(id);
            if (manufacturer.isPresent()) {
                this.manufacturerRepository.deleteById(id);
                return manufacturer.get();
            }
        }
        return null;
    }
}
