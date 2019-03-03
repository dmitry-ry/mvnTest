package services.db;

import model.db.UserDataSet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class DBConnectService {
    private static final Logger logger = LoggerFactory.getLogger(DBConnectService.class);

    private DBConnectService() { }

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (Objects.isNull(sessionFactory)) {
            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(UserDataSet.class);
                configuration.configure();
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception ex) {
                logger.error("Unable to create SessionFactory", ex);
                throw ex;
            }
        }
        return sessionFactory;
    }
}
