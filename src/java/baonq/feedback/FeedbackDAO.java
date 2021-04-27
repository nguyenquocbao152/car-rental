/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.feedback;

import baonq.rentaldetails.RentDetails;
import baonq.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Administrator
 */
public class FeedbackDAO implements Serializable{
    public void insert(FeedBackDTO fb) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Insert into FeedBack(rentID, carID, message) "
                         + "Values(?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, fb.getRentID());
                stm.setString(2, fb.getCarID());
                stm.setString(3, fb.getMessage());
                
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
}
