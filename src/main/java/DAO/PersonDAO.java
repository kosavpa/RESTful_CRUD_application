package DAO;

import Model.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> getPersonList();
    Person findById(long id);
    void save(Person person);
    void update(Person person);
    void delete(Person person);
}
