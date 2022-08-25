package DAO;

import Configs.DataConfig.HibernateUtil;
import Model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAOImpl implements PersonDAO {

    public HibernateUtil util;

    public PersonDAOImpl(@Autowired HibernateUtil util) {
        this.util = util;
    }

    public List<Person> getPersonList() {
        List<Person> allPerson;

        Session session = util.getSessionFactory().openSession();
        allPerson = (List<Person>) session.createQuery("from Person").list();

        return allPerson;
    }

    public Person findById(long id) {
        Person person;

        Session session = util.getSessionFactory().openSession();
        person = (Person) session.get(Person.class, id);
        session.close();

        if(person == null) return new Person();

        return person;
    }

    public void save(Person person) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(person);
        transaction.commit();
        session.close();
    }

    public void update(Person person) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(person);
        transaction.commit();
        session.close();
    }

    public void delete(Person person) {
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(person);
        transaction.commit();
        session.close();
    }
}
