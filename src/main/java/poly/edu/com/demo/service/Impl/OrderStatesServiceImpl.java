package poly.edu.com.demo.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.com.demo.entity.OrderStates;
import poly.edu.com.demo.repositories.IOrderStatesRepository;
import poly.edu.com.demo.service.OrderStatesService;

import java.util.List;

@Service
public class OrderStatesServiceImpl implements OrderStatesService {

    @Autowired
    private IOrderStatesRepository statesRepository;

    @Override
    public List<OrderStates> getAllOrderStates() {
        return this.statesRepository.findAll();
    }
}
