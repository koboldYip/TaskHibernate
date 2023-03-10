package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        User user1 = new User("Thomas", "Martin", (byte) 24);
        User user2 = new User("Jack", "Wilson", (byte) 10);
        User user3 = new User("Olivia", "Smith", (byte) 56);
        User user4 = new User("Amelia", "Brown", (byte) 34);
        List<User> users = Arrays.asList(user1, user2, user3, user4);

        for (User user :
                users) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
        }

        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
