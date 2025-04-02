package com.example.ecomproject.controller;
import com.example.ecomproject.Product;
import com.example.ecomproject.service.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class productcontroller {
       @Autowired
       productservice service;
       @GetMapping("/products")
       public ResponseEntity<List<Product>> getall(){
              return new ResponseEntity<>(service.Getall(), HttpStatus.OK);
       }

       @GetMapping("/product/{id}")
       public ResponseEntity<Product> getbyid(@PathVariable int id)
       {
              Product prd=service.getProductById(id);
              if(prd!=null) {
                     return new ResponseEntity<>(prd,HttpStatus.OK);
                            }
              else
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       @PostMapping("/product")
       public ResponseEntity<?> addproduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
              try {
                    Product product1= service.addproduct(product, imageFile);
                     return new ResponseEntity<>(product1,HttpStatus.CREATED);
              }
              catch (Exception e){
                     return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

              }

       }
       @GetMapping("product/{productid}/image")
       public ResponseEntity<byte[]>getimg(@PathVariable int productid ){
              Product product= service.getProductById(productid);

              byte[] image = product.getImageData();

              return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(image);
       }
       @PutMapping("product/{id}")
       public ResponseEntity<String>updateproduct(@PathVariable int id ,@RequestPart Product product, @RequestPart MultipartFile imageFile) {
              Product product1= null;

                     try {
                            product1=service.updateproduct(id,product,imageFile);
                     } catch (IOException e) {
                            return new  ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
                     }
              if (product1 !=null)
              {
                     return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
              }
              else {
                     return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
              }

       }

       @DeleteMapping("product/{id}")
       public ResponseEntity<String> deleteproduct(@PathVariable int id){

              Product product= service.getProductById(id);
              if(product != null){
                     service.deleteproduct(id);
                     return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
              }
              else
                     return new ResponseEntity<>("Not Found",HttpStatus.BAD_REQUEST);
       }

       @GetMapping("products/search")
       public ResponseEntity<List<Product>> search(@RequestParam String keyword)
       {
              List<Product> products=service.searchProduct(keyword);
              return new ResponseEntity<>(products,HttpStatus.OK);
       }

}
