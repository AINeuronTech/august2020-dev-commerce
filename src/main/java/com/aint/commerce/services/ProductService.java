package com.aint.commerce.services;

import com.aint.commerce.datarepository.ProductRepository;
import com.aint.commerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;

    public List<Product> retrieveAllProducts(){
        List<Product> listOfProducts = (List<Product>) productRepository.findAll();

        return listOfProducts;
    }

    public void createProduct(Product product){
        productRepository.save(product);
    }

    public Optional<Product> findProductById(Integer id){
        return productRepository.findById(id);
    }

    public Product updateProduct(Product product, Integer id){
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

}
