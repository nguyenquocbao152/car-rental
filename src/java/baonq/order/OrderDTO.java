/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.order;

import baonq.account.AccountDTO;
import baonq.car.CarDTO;
import baonq.items.Item;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class OrderDTO implements Serializable{
    private String orderID;
    private AccountDTO customer;
    private float total;
    private List<Item> list;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, AccountDTO customer, float total, List<Item> list) {
        this.orderID = orderID;
        this.customer = customer;
        this.total = total;
        this.list = list;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public AccountDTO getCustomer() {
        return customer;
    }

    public void setCustomer(AccountDTO customer) {
        this.customer = customer;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
    
    
}
