package com.aint.commerce.datarepository;

import com.aint.commerce.entity.Person;
import com.aint.commerce.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends CrudRepository<Person,Integer> {

}
