package Service;

import Model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPerson();
    Person getPersonById(long id);
    void updatePerson(Person person);
    void addNewPerson(Person person);
    void deletePerson(Person person);
}
