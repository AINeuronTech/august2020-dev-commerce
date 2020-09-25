package com.aint.commerce.restcontroller;

import com.aint.commerce.entity.Product;
import com.aint.commerce.services.ProductNPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdNEmployeeController {

   @Autowired
    private ProductNPersonService productNPersonService;

    @GetMapping("/get-product")
    public ResponseEntity<List<Product>> getAllProduct() {

        List<Product> product = productNPersonService.getAllProduct();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

        Product prod = productNPersonService.addProduct(product);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {

        Product prod = productNPersonService.editPerson(product);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> deleteProduct(@RequestParam(name = "productId") Integer productId) {

        productNPersonService.deletePerson(productId);
        return new ResponseEntity<>("Product with ID :" + productId + " deleted successfully", HttpStatus.OK);
    }



}

