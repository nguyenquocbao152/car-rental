/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.rentals;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class RettalDTO implements Serializable{
    private String rentID;
    private String email;
    private Date date;
    private float total;

    public RettalDTO() {
    }

    public RettalDTO(String rentID, String email, Date date, float total) {
        this.rentID = rentID;
        this.email = email;
        this.date = date;
        this.total = total;
    }

    public String getRentID() {
        return rentID;
    }

    public void setRentID(String rentID) {
        this.rentID = rentID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "RettalDTO{" + "rentID=" + rentID + ", email=" + email + ", date=" + date + ", total=" + total + '}';
    }

    
    
    
}
