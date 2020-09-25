package com.aint.commerce.datarepository;

import com.aint.commerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

//     List<Product> findByPersonId(Integer personId);
//     Optional<Product> findByProdIdAndPersonId(Integer prodId, Integer personId);

}
