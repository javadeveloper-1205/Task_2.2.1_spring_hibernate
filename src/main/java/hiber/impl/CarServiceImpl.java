package hiber.impl;

import hiber.dao.CarsDao;
import hiber.dao.CarsService;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarsService {
    
    @Autowired
    private CarsDao carDao;

    @Transactional
    @Override
    public void add(Car car) {
        carDao.addCars(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars() {
        return carDao.listCars();
    }
}
