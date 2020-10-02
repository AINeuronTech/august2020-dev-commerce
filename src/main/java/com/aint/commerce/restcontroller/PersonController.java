package com.aint.commerce.restcontroller;

import com.aint.commerce.entity.Person;
import com.aint.commerce.entity.Product;
import com.aint.commerce.services.PersonService;
import com.aint.commerce.services.ProductNPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {


    @Autowired
    private PersonService personService;

    @GetMapping("/getPerson")
    public ResponseEntity<List<Person>> getAllPerson() {

        List<Person> person = personService.getAllPerson();
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {

        Person person1 = personService.addPerson(person);
        return new ResponseEntity<>(person1, HttpStatus.OK);
    }

    @PutMapping("/person")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {

        Person person1 = personService.editPerson(person);
        return new ResponseEntity<>(person1, HttpStatus.OK);
    }

    @DeleteMapping("/person")
    public ResponseEntity<String> deleteProduct(@RequestParam(name = "personId") Integer personId) {

        personService.deletePerson(personId);
        return new ResponseEntity<>("Person with ID :" + personId + " deleted successfully", HttpStatus.OK);
    }

}
