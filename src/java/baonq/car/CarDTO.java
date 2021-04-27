/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.car;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class CarDTO implements Serializable{
    private String carID;
    private String color;
    private String carName;
    private float price;
    private int quantity;
    private String year;
    private String title;
    private String image;
    private String cateID;

    public CarDTO() {
    }

    public CarDTO(String carID, String color, String carName, float price, int quantity, String year, String title, String image, String cateID) {
        this.carID = carID;
        this.color = color;
        this.carName = carName;
        this.price = price;
        this.quantity = quantity;
        this.year = year;
        this.title = title;
        this.image = image;
        this.cateID = cateID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    @Override
    public String toString() {
        return "CarDTO{" + "carID=" + carID + ", color=" + color + ", carName=" + carName + ", price=" + price + ", quantity=" + quantity + ", year=" + year + ", title=" + title + ", image=" + image + ", cateID=" + cateID + '}';
    }

    

    
    
    
}
