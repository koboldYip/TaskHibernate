package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Util {

    private static final String hostName = "localhost";
    private static final String dbName = "db";
    private static final String userName = "root";
    private static final String password = "root";
    public static SessionFactory factory;

    private Util() {
    }

    public static SessionFactory buildSessionFactory() {
        if (factory == null) {
            Configuration configuration = new Configuration();
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            properties.put(Environment.URL, String.format("jdbc:mysql://%s:3306/%s", hostName, dbName));
            properties.put(Environment.USER, userName);
            properties.put(Environment.PASS, password);
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
//        properties.put(Environment.SHOW_SQL, "true");
//        properties.put(Environment.FORMAT_SQL, "true");
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(User.class);
            factory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build());
        }
        return factory;
    }
}
