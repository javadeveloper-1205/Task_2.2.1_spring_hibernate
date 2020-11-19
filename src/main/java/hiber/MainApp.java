package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarServiceImpl;
import hiber.service.CarsService;
import hiber.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarsService car = context.getBean(CarsService.class);


        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Toyota", 15)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Honda", 12)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Kia", 15)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Jeep", 34)));

        List<User> users = userService.listUsers();
        List<User> usersModelandSeries = userService.listHQLModelAndSeries();


        for (User user : users) {
            if (users.isEmpty()) {
                System.out.println("Id = " + user.getId());
                System.out.println("First Name = " + user.getFirstName());
                System.out.println("Last Name = " + user.getLastName());
                System.out.println("Email = " + user.getEmail());
                System.out.println();
            }
        }

        context.close();
    }
}
