/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.category;

import baonq.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
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
public class CategoryDAO implements Serializable{
    public List<CategoryDTO> getAllCategory() throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CategoryDTO> list = new ArrayList();
        try {
            con = DBUtils.getConnection();
            if(con!=null){
                String sql = "Select cateID, cateName "
                        + "From Category";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while(rs.next()){
                    String cateID = rs.getString("cateID");
                    String cateName = rs.getString("cateName");
                    CategoryDTO dto = new CategoryDTO(cateID, cateName);
                    list.add(dto);
                }
            }
        }finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                stm.close();
            }
        }
        return list;
    }
}
