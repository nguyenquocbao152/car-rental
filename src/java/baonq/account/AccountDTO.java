/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.account;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class AccountDTO implements Serializable{
    private String email;
    private String password;
    private String fullname;
    private String phone;
    private String address;
    private Date createDate;
    private String status;

    public AccountDTO() {
    }

    public AccountDTO(String email, String password, String fullname, String phone, String address, Date createDate, String status) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.createDate = createDate;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AccountDTO{" + "email=" + email + ", password=" + password + ", fullname=" + fullname + ", phone=" + phone + ", address=" + address + ", createDate=" + createDate + ", status=" + status + '}';
    }
    
    
    
}
