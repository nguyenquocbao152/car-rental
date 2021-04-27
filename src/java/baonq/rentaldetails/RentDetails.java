/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.rentaldetails;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class RentDetails implements Serializable{
    private String rentID;
    private String carID;
    private Date dateRent;
    private Date dateReturn;
    private float price;
    private int quantity;

    public RentDetails() {
    }

    public RentDetails(String rentID, String carID, Date dateRent, Date dateReturn, float price, int quantity) {
        this.rentID = rentID;
        this.carID = carID;
        this.dateRent = dateRent;
        this.dateReturn = dateReturn;
        this.price = price;
        this.quantity = quantity;
    }

    public String getRentID() {
        return rentID;
    }

    public void setRentID(String rentID) {
        this.rentID = rentID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public Date getDateRent() {
        return dateRent;
    }

    public void setDateRent(Date dateRent) {
        this.dateRent = dateRent;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
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

    @Override
    public String toString() {
        return "RentDetails{" + "rentID=" + rentID + ", carID=" + carID + ", dateRent=" + dateRent + ", dateReturn=" + dateReturn + ", price=" + price + ", quantity=" + quantity + '}';
    }

    

    
    
}
