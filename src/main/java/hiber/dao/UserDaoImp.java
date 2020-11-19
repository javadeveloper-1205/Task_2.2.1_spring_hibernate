package hiber.dao;

import hiber.model.User;
import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void drop(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();
    }

    @Override
    public List<User> listUsers2() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("DELETE User");
        return query.getResultList();
    }

    @Override
    public List<User> listHQLModelAndSeries() {
        String hql = "FROM User users LEFT JOIN FETCH users.car WHERE users.car=:model and users.car=:series";
        Query query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
        query.setParameter("model", "Kia");
        query.setParameter("series", 15);
        List<User> users = query.getResultList();
        return users;
    }
}
