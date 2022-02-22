package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    static Connection dbConnection;
    static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/i_love_jdbc";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    //jdbc connection
    public static Connection getConnection() {
        if (dbConnection == null) {
            try {
                dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dbConnection;
    }

    //hibernate connection
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();

                properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                properties.put(Environment.URL, DB_URL);
                properties.put(Environment.USER, DB_USER);
                properties.put(Environment.PASS, DB_PASSWORD);
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);

                serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
            }
        }
        return sessionFactory;
    }
}
