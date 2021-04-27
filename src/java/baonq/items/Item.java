/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.items;

import baonq.car.CarDTO;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class Item implements Serializable{
    private String id;
    private CarDTO car;
    private int quantity;
    private float price;
    private Date rentDate;
    private Date returnDate;
    private int amountRented;

    public Item() {
    }

    public Item(String id, CarDTO car, int quantity, float price, Date rentDate, Date returnDate, int amountRented) {
        this.id = id;
        this.car = car;
        this.quantity = quantity;
        this.price = price;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.amountRented = amountRented;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getAmountRented() {
        return amountRented;
    }

    public void setAmountRented(int amountRented) {
        this.amountRented = amountRented;
    }

    

    
    
    
}
