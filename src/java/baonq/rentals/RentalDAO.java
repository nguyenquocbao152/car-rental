/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.rentals;

import baonq.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Administrator
 */
public class RentalDAO {
    public void insertRental(String rentID,String email,float total) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if(con!=null){
                String sql = "Insert into Renting(rentID, email, total) "
                         + "Values(?, ?, ?)";
                stm  = con.prepareStatement(sql);
                stm.setString(1, rentID);
                stm.setString(2,email);
                stm.setFloat(3, total);
                stm.executeUpdate();
            }
        }finally {
            if(stm!=null){
                stm.close();
                
            }
            if(con!=null){
                con.close();
            }
        }
    }
    
    public RettalDTO checkDuplicate(String renID) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if(con!=null){
                String sql = "Select rentID, email, date, total "
                         + "From Renting "
                         + "Where rentID = ?";
                stm  = con.prepareStatement(sql);
                stm.setString(1, renID);                
                rs = stm.executeQuery();
                if(rs.next()){
                    String id = rs.getString("rentID");
                    String email = rs.getString("email");
                    Date date = rs.getDate("date");
                    float total = rs.getFloat("total");
                    RettalDTO rt = new RettalDTO(renID, email, date, total);
                    return rt;
                }
            }
        }finally {
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
    
    public List<RettalDTO> getAll(String mail) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RettalDTO> list = new ArrayList();
        try {
            con = DBUtils.getConnection();
            if(con!=null){
                String sql = "Select rentID, email, date, total "
                         + "From Renting "
                         + "Where email = ?";
                         
                stm  = con.prepareStatement(sql); 
                stm.setString(1, mail);
                rs = stm.executeQuery();
                while(rs.next()){
                    String id = rs.getString("rentID");
                    String email = rs.getString("email");
                    Date date = rs.getDate("date");
                    float total = rs.getFloat("total");
                    RettalDTO rt = new RettalDTO(id, email, date, total);
                    list.add(rt);
                }
            }
        }finally {
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
        return list;
    }
    
   public void delele(String rentID,String status) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if(con!=null){
                String sql = "Update Renting "
                         + "Set status = ?"
                         + "Where rentID = ?";
                stm  = con.prepareStatement(sql);
                stm.setString(1, status); 
                stm.setString(2, rentID); 
                stm.executeUpdate();
            }
        }finally {
            if(stm!=null){
                stm.close();
                
            }
            if(con!=null){
                con.close();
            }
        }
    }
    
    
}
