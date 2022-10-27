package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        userService.saveUser("Nurkyz", "Kasymova", (byte)20);
        userService.saveUser("Zhazgul", "Sarybaeva", (byte) 19);
        userService.saveUser("Madina", "Musaeva", (byte) 16);
        userService.saveUser("Erjigit", "Kalmyrzaev", (byte) 18);

        userService.createUsersTable();

        /* System.out.println(userService.getAllUsers());*/

        //userService.cleanUsersTable();

        //userService.dropUsersTable();
    }
}
