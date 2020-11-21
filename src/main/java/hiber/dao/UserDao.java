package hiber.dao;

import hiber.model.User;


import java.util.List;

public interface UserDao {
    void add(User user);
    void drop(User user);

    List<User> listUsers();
    List<User> listUsers2();
    List<User> listHQLModelAndSeries(String name, int series);
}



