package com.example.ecomproject.service;

import com.example.ecomproject.Product;
import com.example.ecomproject.repo.productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class productservice {
       @Autowired
       productrepo repo;
       public List<Product> Getall(){
              return repo.findAll();
       }

       public Product getProductById(int id) {
              return repo.findById(id).orElse(null);
       }

       public Product addproduct(Product product, MultipartFile imageFile) throws IOException {

              product.setImageName(imageFile.getOriginalFilename());
              product.setImageType(imageFile.getContentType());
              product.setImageData(imageFile.getBytes());
             return repo.save(product);
       }

       public Product updateproduct(int id, Product product, MultipartFile imageFile) throws IOException {
              product.setImageName(imageFile.getOriginalFilename());
              product.setImageType(imageFile.getContentType());
              product.setImageData(imageFile.getBytes());
             return repo.save(product);

       }

       public void deleteproduct(int id) {
              repo.deleteById(id);
       }

       public List<Product> searchProduct(String keyword) {

              return repo.searchproducts(keyword);
       }
}
