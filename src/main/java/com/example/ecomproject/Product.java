package com.example.ecomproject;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int id;

       private String name;
       private String description;
       private String brand;
       private String category;
       private int price;
       private int stockQuantity;
       private Date releaseDate;
       private boolean productAvailable;
       private String imageName;
       private String imageType;
       @Lob
       private byte[] imageData;

       public int getId() {
              return id;
       }

       public void setId(int id) {
              this.id = id;
       }

       public String getName() {
              return name;
       }

       public void setName(String name) {
              this.name = name;
       }

       public String getDescription() {
              return description;
       }

       public void setDescription(String description) {
              this.description = description;
       }

       public String getBrand() {
              return brand;
       }

       public void setBrand(String brand) {
              this.brand = brand;
       }

       public String getCategory() {
              return category;
       }

       public void setCategory(String category) {
              this.category = category;
       }

       public int getPrice() {
              return price;
       }

       public void setPrice(int price) {
              this.price = price;
       }

       public int getStockQuantity() {
              return stockQuantity;
       }

       public void setStockQuantity(int stockQuantity) {
              this.stockQuantity = stockQuantity;
       }

       public Date getReleaseDate() {
              return releaseDate;
       }

       public void setReleaseDate(Date releaseDate) {
              this.releaseDate = releaseDate;
       }

       public boolean isProductAvailable() {
              return productAvailable;
       }

       public void setProductAvailable(boolean productAvailable) {
              this.productAvailable = productAvailable;
       }

       public String getImageName() {
              return imageName;
       }

       public void setImageName(String imageName) {
              this.imageName = imageName;
       }

       public String getImageType() {
              return imageType;
       }

       public void setImageType(String imageType) {
              this.imageType = imageType;
       }

       public byte[] getImageData() {
              return imageData;
       }

       public void setImageData(byte[] imageDate) {
              this.imageData = imageDate;
       }
}

