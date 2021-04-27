/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.account;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class AccountError implements Serializable{
    private String emailError;
    private String nameError;
    private String addError;
    private String phoneError;
    private String confirmError;
    private String dulicateEmail;
    private String pasError;

    public AccountError() {
    }

    public AccountError(String emailError, String nameError, String addError, String phoneError, String confirmError, String dulicateEmail, String pasError) {
        this.emailError = emailError;
        this.nameError = nameError;
        this.addError = addError;
        this.phoneError = phoneError;
        this.confirmError = confirmError;
        this.dulicateEmail = dulicateEmail;
        this.pasError = pasError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getAddError() {
        return addError;
    }

    public void setAddError(String addError) {
        this.addError = addError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getDulicateEmail() {
        return dulicateEmail;
    }

    public void setDulicateEmail(String dulicateEmail) {
        this.dulicateEmail = dulicateEmail;
    }

    public String getPasError() {
        return pasError;
    }

    public void setPasError(String pasError) {
        this.pasError = pasError;
    }

    
    
}
