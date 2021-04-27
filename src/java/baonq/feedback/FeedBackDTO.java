/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.feedback;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class FeedBackDTO implements Serializable{
    private String rentID;
    private String carID;
    private String message;

    public FeedBackDTO() {
    }

    public FeedBackDTO(String rentID, String carID, String message) {
        this.rentID = rentID;
        this.carID = carID;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
 
}
