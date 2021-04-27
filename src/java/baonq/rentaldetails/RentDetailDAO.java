/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.rentaldetails;

import baonq.utils.DBUtils;
import java.io.Serializable;
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
public class RentDetailDAO implements Serializable {

    public RentDetails getQuantyRent(String ID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select RentDetails.dateRent,RentDetails.dateTerm,RentDetails.quantity,RentDetails.price,RentDetails.rentID,RentDetails.carID "
                        + "From RentDetails left join Car on Car .carID = RentDetails.carID "
                        + "Where Car.carID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, ID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String carID = rs.getString("carID");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String rentID = rs.getString("rentID");
                    Date daterent = rs.getDate("dateRent");
                    Date dateterm = rs.getDate("dateTerm");

                    RentDetails rt = new RentDetails(rentID, carID, daterent, dateterm, price, quantity);
                    return rt;

                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;

    }

    public void insert(RentDetails rd) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Insert into RentDetails(rentID, carID, dateRent, dateTerm, price, quantity) "
                         + "Values(?, ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, rd.getRentID());
                stm.setString(2, rd.getCarID());
                stm.setDate(3, rd.getDateRent());
                stm.setDate(4, rd.getDateReturn());
                stm.setFloat(5, rd.getPrice());
                stm.setInt(6, rd.getQuantity());
                stm.executeUpdate();                
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public List<RentDetails> getRentByID(String ID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RentDetails> list = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select dateRent,dateTerm,quantity,price,rentID,carID "
                        + "From RentDetails "
                        + "Where rentID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, ID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String carID = rs.getString("carID");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String rentID = rs.getString("rentID");
                    Date daterent = rs.getDate("dateRent");
                    Date dateterm = rs.getDate("dateTerm");

                    RentDetails rt = new RentDetails(rentID, carID, daterent, dateterm, price, quantity);
                    list.add(rt);

                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;

    }
    
    
}
