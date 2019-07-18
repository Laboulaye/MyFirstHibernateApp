package dao;

import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;


//DAO слой, который отвечает за доступ к данным и все операции с данными
public class UserDao {

    public User findById(int id) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(User.class, id);
    }

    public void save(User user) {
        //получаем объект сессии (сессия соединения с БД)
        Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();
        //с помощью сессии создаем одиночную транзакцию в БД
        Transaction tx1 = session.beginTransaction();
        //выполняем необходимые преобразования данных
        session.save(user);
        //сохраняем результат транзакции в БД
        tx1.commit();
        //закрываем сессию
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }


    public List<User> findAll() {
        List<User> users = (List<User>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();
        return users;
    }
}
