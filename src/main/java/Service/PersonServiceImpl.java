package Service;

import DAO.PersonDAO;
import Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonServiceImpl implements PersonService{
    private PersonDAO dao;

    public PersonServiceImpl(@Autowired PersonDAO dao) {
        this.dao = dao;
    }

    public List<Person> getAllPerson() {
        List<Person> personsList = dao.getPersonList();

        return personsList;
    }

    public Person getPersonById(long id) {
        Person person = dao.findById(id);

        return person;
    }

    public void updatePerson(Person person) {
        dao.update(person);
    }

    public void addNewPerson(Person person) {
        dao.save(person);
    }

    public void deletePerson(Person person) {
        dao.delete(person);
    }
}
