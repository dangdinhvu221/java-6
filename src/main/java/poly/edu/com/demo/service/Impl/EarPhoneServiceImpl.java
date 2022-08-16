package poly.edu.com.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.com.demo.entity.EarPhone;
import poly.edu.com.demo.entity.Manufacturer;
import poly.edu.com.demo.entity.typeEnum.TypeCondition;
import poly.edu.com.demo.entity.typeEnum.TypeEarPhone;
import poly.edu.com.demo.repositories.IEarPhoneRepository;
import poly.edu.com.demo.repositories.IManufacturerRepository;
import poly.edu.com.demo.service.EarPhoneService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Service
public class EarPhoneServiceImpl implements EarPhoneService {

    @Autowired
    private IEarPhoneRepository earPhoneRepository;
    @Autowired
    private IManufacturerRepository manufacturerRepository;

    @Override
    public EarPhone addEarPhone(EarPhone earPhone) {
        return this.earPhoneRepository.save(earPhone);
    }

    @Override
    public EarPhone updateEarPhone(EarPhone earPhone) {
        Long id = earPhone.getId();
        try {
            if (id != null) {
                Optional<EarPhone> e = this.earPhoneRepository.findById(id);
                if (e.isPresent()) {
                    earPhone.setId(id);
                    this.earPhoneRepository.save(earPhone);
                }
            }
            return earPhone;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<EarPhone> getAllEarPhones() {
        return this.earPhoneRepository.findAllProduct();
    }

    @Override
    public List<EarPhone> findAllProductAdmin() {
        return earPhoneRepository.findAll();
    }

    @Override
    public EarPhone getEarPhone(Long id) {
        return this.earPhoneRepository.findById(id).get();
    }

    @Override
    public EarPhone deleteEarPhone(Long id) {
        if (id != null) {
            Optional<EarPhone> e = this.earPhoneRepository.findById(id);
            if (e.isPresent()) {
                this.earPhoneRepository.deleteById(id);
                return e.get();
            }
        }
        return null;
    }

    @Override
    public void deleteAllEarPhone(Long[] id) {
        this.earPhoneRepository.deleteAllByIdInBatch(Arrays.asList(id));
    }

    @Override
    public List<EarPhone> findByCategoryId(String cid) {
        return earPhoneRepository.findByCategoryId(cid);
    }
}
