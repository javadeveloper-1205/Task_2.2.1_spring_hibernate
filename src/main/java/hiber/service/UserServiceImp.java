package hiber.service;

import hiber.dao.CarsDao;
import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private CarsDao carsDao;

    @Transactional
    @Override
    public void add(User user) {
        if (user.getCar() != null) {
            carsDao.addCars(user.getCar());
        }
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public List<User> listHQLModelAndSeries() {
        return userDao.listHQLModelAndSeries("Kia", 212);
    }
}
