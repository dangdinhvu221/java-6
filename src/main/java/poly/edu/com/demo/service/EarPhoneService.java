package poly.edu.com.demo.service;


import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.com.demo.entity.EarPhone;
import poly.edu.com.demo.entity.Manufacturer;
import poly.edu.com.demo.entity.typeEnum.TypeCondition;
import poly.edu.com.demo.entity.typeEnum.TypeEarPhone;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface EarPhoneService {
    EarPhone addEarPhone(EarPhone earPhonez);

    EarPhone updateEarPhone(EarPhone earPhone);

    List<EarPhone> getAllEarPhones();

    EarPhone getEarPhone(Long id);

    EarPhone deleteEarPhone(Long id);

    void deleteAllEarPhone(Long[] id);

    List<EarPhone> findAllProductAdmin();

    List<EarPhone> findByCategoryId(String cid);
}
