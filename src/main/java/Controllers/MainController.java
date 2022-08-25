package Controllers;

import Model.Person;
import Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public List<Person> getAllPerson(){
        List<Person> personsList = personService.getAllPerson();

        return personsList;
    }

    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable long id){
        Person person = personService.getPersonById(id);

        return person;
    }

    @DeleteMapping("/persons/delete")
    public ResponseEntity<HttpStatus> deletePerson(@RequestBody Person person){
        personService.deletePerson(person);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping("/persons/new")
    public ResponseEntity<Person> createNewPerson(@RequestBody Person person){
        personService.addNewPerson(person);

        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PostMapping("/persons/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        personService.updatePerson(person);
        Person updatedPerson = personService.getPersonById(person.getId());
        return new ResponseEntity<>(updatedPerson, HttpStatus.ACCEPTED);
    }
}
