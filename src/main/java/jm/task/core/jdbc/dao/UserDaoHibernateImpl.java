package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    Session session = Util.getSessionFactory().openSession();

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n" +
                "        `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "        `name` VARCHAR(45) NOT NULL,\n" +
                "        `last_name` VARCHAR(45) NOT NULL,\n" +
                "        `age` INT,\n" +
                "        PRIMARY KEY (`id`));";
        Transaction transaction = session.beginTransaction();
        try {
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";
        Transaction transaction = session.beginTransaction();
        try {
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(new User(name, lastName, age));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = session.beginTransaction();
        try {
            session.remove(session.get(User.class, id));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public List<User> getAllUsers() {
        String hql = "From User";
        List<User> userList = null;
        try {
            session.createQuery(hql).list();
        } catch (Exception e) {
        }
        return userList;
    }


    @Override
    public void cleanUsersTable() {
        String hql = "delete from users";
        Transaction transaction = session.beginTransaction();
        try {
            session.createSQLQuery(hql).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
