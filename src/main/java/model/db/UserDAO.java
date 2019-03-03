package model.db;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import services.db.DBConnectService;

public class UserDAO {

    public void save(UserDataSet user) {
        Session session = DBConnectService.getSessionFactory().openSession();
        Transaction trx = session.beginTransaction();
        session.save(user);
        trx.commit();
        session.close();
    }

    public void update(UserDataSet user) {
        Session session = DBConnectService.getSessionFactory().openSession();
        Transaction trx = session.beginTransaction();
        session.update(user);
        trx.commit();
        session.close();
    }

    public void delete(UserDataSet user) {
        Session session = DBConnectService.getSessionFactory().openSession();
        Transaction trx = session.beginTransaction();
        session.delete(user);
        trx.commit();
        session.close();
    }

    public UserDataSet findById(long id) {
        Session session = DBConnectService.getSessionFactory().openSession();
        return session.get(UserDataSet.class, id);
    }

    public UserDataSet findByLogin(String login) {
        Session session = DBConnectService.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserDataSet.class);
        criteria.add(Restrictions.eq("login", login));
        return ((UserDataSet) criteria.uniqueResult());
    }
}
