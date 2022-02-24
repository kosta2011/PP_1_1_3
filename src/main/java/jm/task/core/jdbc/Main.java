package jm.task.core.jdbc;

import jm.task.core.jdbc.GenerateRandomUser.GenerateUser;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        for (int i = 0; i < 4; i++) {
            String name = GenerateUser.getName();
            userService.saveUser(name, GenerateUser.getLastName(), GenerateUser.getAge());
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        }

        for (User i : userService.getAllUsers()) {
            System.out.println(i);
        }


        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.getSessionFactory().close();
    }
}
