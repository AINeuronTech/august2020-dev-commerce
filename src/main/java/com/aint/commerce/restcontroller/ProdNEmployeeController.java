package com.aint.commerce.restcontroller;

import com.aint.commerce.entity.Product;
import com.aint.commerce.services.ProductNPersonService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@ApiResponses( value = {
        @ApiResponse(code = 400, message = "This is bad client call, please read the API GET format"),
        @ApiResponse(code = 401, message = "Security Enabled, Need Authorization"),
        @ApiResponse(code = 500, message = "probably Server is down, Please Contact Admin/DevOps@aineurontech.com"),
})
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

        Product prod = productNPersonService.editProduct(product);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> deleteProduct(@RequestParam(name = "productId") Integer productId) {

        productNPersonService.deleteProduct(productId);
        return new ResponseEntity<>("Product with ID :" + productId + " deleted successfully", HttpStatus.OK);
    }

}

