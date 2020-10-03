package com.aint.commerce.restcontroller;

import com.aint.commerce.entity.Product;
import com.aint.commerce.services.ProductService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@ApiResponses( value = {
        @ApiResponse(code = 400, message = "This is bad client call, please read the API GET format"),
        @ApiResponse(code = 401, message = "Security Enabled, Need Authorization"),
        @ApiResponse(code = 500, message = "probably Server is down, Please Contact Admin/DevOps@aineurontech.com"),
})
public class ProductController {

    public ProductService productService;


    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/getProduct", headers = "Accept=application/json")
    public List<Product> getProfile(){
        return productService.retrieveAllProducts();
    }

    @GetMapping(value = "/getProduct/{id}", headers = "Accept=application/json")
    public Optional<Product> getSingleProfile(@PathVariable Integer id){
        return productService.findProductById(id);
    }

    @PostMapping(value = "/postProfile", headers = "Accept=application/json")
    public ResponseEntity<Void> createProfile(@RequestBody Product product, UriComponentsBuilder uriComponentsBuilder){
        productService.createProduct(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/api/{id}").buildAndExpand(product.getProdId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateProduct", headers = "Accept=application/json")
    public ResponseEntity<String> updateProfile(@RequestBody Product currentProduct){
        Optional<Product> updatedProduct = productService.findProductById(currentProduct.getProdId());
        if(updatedProduct==null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        productService.updateProduct(currentProduct,currentProduct.getProdId());
        return new ResponseEntity<String>(HttpStatus.OK);

    }

    @DeleteMapping(value = "/deleteProduct/{id}", headers = "Accept=application/json")
    public ResponseEntity<String> deleteProfile(@PathVariable Integer id){
        Optional<Product> product = productService.findProductById(id);
        if(product==null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(id);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);

    }

}
