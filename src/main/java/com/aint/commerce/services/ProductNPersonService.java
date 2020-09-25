package com.aint.commerce.services;

import com.aint.commerce.datarepository.PersonRepository;
import com.aint.commerce.datarepository.ProductRepository;
import com.aint.commerce.entity.Person;
import com.aint.commerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductNPersonService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        Person person = personRepository.findById(product.getPerson().getPersonId()).orElse(null);
        if(null == person){
            person = new Person();
        }
        person.setPersonName(product.getPerson().getPersonName());
        product.setPerson(person);
        return  productRepository.save(product);
    }

    public Product editPerson(Product product){
        return productRepository.save(product);
    }

    public void deletePerson(Integer id){
        productRepository.deleteById(id);
    }
}
