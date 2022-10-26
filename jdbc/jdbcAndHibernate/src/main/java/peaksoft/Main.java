package peaksoft;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
     //   userDaoHibernate.dropUsersTable();

        //Util.createsessionFactory();

        userDaoHibernate.saveUser("Nurkyz", "Kasymova", (byte)20);
        userDaoHibernate.saveUser("Zhazgul", "Sarybaev", (byte) 19);
        userDaoHibernate.saveUser("Madina", "Musaeva", (byte) 16);
        userDaoHibernate.saveUser("Erjigit", "Kalmyrzaev", (byte) 18);

        /* System.out.println(userService.getAllUsers());*/

        //userService.cleanUsersTable();

        //userService.dropUsersTable();
    }
}
