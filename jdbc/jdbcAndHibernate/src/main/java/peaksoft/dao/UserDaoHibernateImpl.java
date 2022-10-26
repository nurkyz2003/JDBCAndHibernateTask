package peaksoft.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.Transaction;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {


    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            Session session = Util.createsessionFactory().openSession();
            session.beginTransaction();
            session.createNativeQuery(
                    "create table IF NOT EXISTS person " +
                            "(id serial PRIMARY KEY, " +
                            "name VARCHAR(50) NOT NULL, " +
                            "lastname VARCHAR(50) NOT NULL, " +
                            "age smallint NOT NULL);").executeUpdate();

            session.getTransaction().commit();
            session.close();
            System.out.println("Table succesfully created");

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = Util.createsessionFactory().openSession();
            session.beginTransaction();
            session.createNativeQuery(
                    "drop table if exists person").executeUpdate();

            session.getTransaction().commit();
            session.close();
            System.out.println(" Table droped succesfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            User user = new User(name, lastName, age);
            Session session = Util.createsessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
            System.out.println(name + "sucsesifal");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try {
            Session session = Util.createsessionFactory().openSession();
            session.beginTransaction();
            User user = (User) session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
            System.out.println("User with id-" + id + " was delete" + user);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            Session session = Util.createsessionFactory().openSession();
            session.beginTransaction();
            List<User> users = session.createQuery("select u from  User u").getResultList();
            session.getTransaction().commit();
            return users;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.createsessionFactory().openSession();
            session.beginTransaction();
            session.createNativeQuery("truncate table person").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("All users were delete");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}