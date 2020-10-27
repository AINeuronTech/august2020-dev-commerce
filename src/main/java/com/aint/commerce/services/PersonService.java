package com.aint.commerce.services;

import com.aint.commerce.datarepository.PersonRepository;
import com.aint.commerce.datarepository.ProductRepository;
import com.aint.commerce.entity.Person;
import com.aint.commerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Person> getAllPerson(){
        return (List<Person>) personRepository.findAll();
    }

    public Person addPerson(Person person){
        Product product = productRepository.findById(person.getPersonId()).orElse(null);
        if(null == product){
            product = new Product();
        }
        product.setProdName(person.getProducts().toString());
        return personRepository.save(person);
        /*
        person.setPersonName(product.getPerson().getPersonName());
        product.setPerson(person);
        return  productRepository.save(product);  */
    }

    public Person editPerson(Person person){
        return personRepository.save(person);
    }

    public void deletePerson(Integer id){
        personRepository.deleteById(id);
    }
}
