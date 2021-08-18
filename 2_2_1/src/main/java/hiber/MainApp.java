package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("ivan", "ivanov", "vasya@ya.ru");
      User user2 = new User("oleg", "olgeov", "oleg@rambler.ru");
      User user3 = new User("petr", "petrov", "petushara@inbox.ru");
      User user4 = new User("ibragim", "akhmedov", "razraz@google.com");

      Car car1 = new Car("Toyota", 100);
      Car car2 = new Car("Mitsubishi", 200);
      Car car3 = new Car("LADA", 2108);
      Car car4 = new Car("Nissan", 400);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
         System.out.println("     " + user.getCar().toString());
      }

      Car car5 = car3;

      System.out.println("Владелец машины " + car5 + "\n" +
                         "==============> " + userService.getOwner(car5).toString());

      context.close();
   }
}
