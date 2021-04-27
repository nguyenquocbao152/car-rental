/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.car;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class CarError implements Serializable{
    private String namError;
    private String cateError;
    private String rentalError;
    private String returEror;
    private String amount;

    public CarError() {
    }

    public CarError(String namError, String cateError, String rentalError, String returEror, String amount) {
        this.namError = namError;
        this.cateError = cateError;
        this.rentalError = rentalError;
        this.returEror = returEror;
        this.amount = amount;
    }

    public String getNamError() {
        return namError;
    }

    public void setNamError(String namError) {
        this.namError = namError;
    }

    public String getCateError() {
        return cateError;
    }

    public void setCateError(String cateError) {
        this.cateError = cateError;
    }

    public String getRentalError() {
        return rentalError;
    }

    public void setRentalError(String rentalError) {
        this.rentalError = rentalError;
    }

    public String getReturEror() {
        return returEror;
    }

    public void setReturEror(String returEror) {
        this.returEror = returEror;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    
    
    
}
