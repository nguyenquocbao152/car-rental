/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.account;

import baonq.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Administrator
 */
public class AccountDAO implements Serializable{
    public AccountDTO checkLogin(String email,String password) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if(con!=null){
                String sql = "Select email, password, phone, fullName, address, createDate, status "
                         + "From Account "
                         + "Where email = ? And password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                    String mail = rs.getString("email");
                    String pass = rs.getString("password");
                    String phone = rs.getString("phone");
                    String fullname = rs.getString("fullName");
                    String add = rs.getString("address");
                    Date create = rs.getDate("createDate");
                    String status = rs.getString("status");
                    AccountDTO dto = new AccountDTO(email, pass, fullname, phone, add, create, status);
                    return dto;
                }
            }
        } finally {
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return null;
    }
    
    public AccountDTO checkDuplicate(String email) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if(con!=null){
                String sql = "Select email, password, phone, fullName, address, createDate, status "
                         + "From Account "
                         + "Where email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);               
                rs = stm.executeQuery();
                if(rs.next()){
                    String mail = rs.getString("email");
                    String pass = rs.getString("password");
                    String phone = rs.getString("phone");
                    String fullname = rs.getString("fullName");
                    String add = rs.getString("address");
                    Date create = rs.getDate("createDate");
                    String status = rs.getString("status");
                    AccountDTO dto = new AccountDTO(mail, pass, fullname, phone, add, create, status);
                    return dto;
                }
            }
        } finally {
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return null;
    }
    
    public void insert(AccountDTO dto ) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if(con!=null){
                String sql = "Insert into Account (email, password, phone, fullName, address, createDate, status) "
                         + "Values(?, ?, ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getEmail());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getPhone());
                stm.setString(4, dto.getFullname());
                stm.setString(5, dto.getAddress());
                stm.setDate(6, dto.getCreateDate());
                stm.setString(7, dto.getStatus());
                stm.executeUpdate();
            }               
        } finally {
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
    }
}
