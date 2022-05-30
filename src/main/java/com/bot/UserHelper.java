package com.bot;

import com.bot.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserHelper {

    private SessionFactory sessionFactory;

    public UserHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<User> getUserList(){
        Session session = sessionFactory.openSession();

        session.get(User.class, 1L);

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery(User.class);

        Root<User> root = cq.from(User.class);

        cq.select(root);

        Query query = session.createQuery(cq);

        List<User> userList = query.getResultList();

        session.close();

        return userList;
    }

    public User getUser(String userName){return null;}
}
