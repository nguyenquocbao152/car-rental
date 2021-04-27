/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.car;

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
public class CarDAO implements Serializable {

    public List<CarDTO> getAllCar() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CarDTO> list = new ArrayList();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select carID, color, carName, cateID, price, quantity, year, title, image "
                        + "From Car";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String color = rs.getString("color");
                    String carName = rs.getString("carName");
                    String cateID = rs.getString("cateID");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String year = rs.getString("year");

                    String title = rs.getString("title");
                    String image = rs.getString("image");
                    CarDTO dto = new CarDTO(carID, color, carName, price, quantity, year, title, image,cateID);
                    list.add(dto);
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

    public CarDTO getCarByID(String caID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select carID, color, carName, cateID, price, quantity, year, title, image "
                        + "From Car "
                        + "Where carID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, caID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String color = rs.getString("color");
                    String carName = rs.getString("carName");
                    String cateID = rs.getString("cateID");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String year = rs.getString("year");
                    String title = rs.getString("title");
                    String image = rs.getString("image");
                    CarDTO dto = new CarDTO(carID, color, carName, price, quantity, year, title, image,cateID);
                    return dto;
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

    public List<CarDTO> getCarByName(String name) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CarDTO> list = new ArrayList();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select carID, color, carName, cateID, price, quantity, year, title, image "
                        + "From Car "
                        + "Where carName Like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String color = rs.getString("color");
                    String carName = rs.getString("carName");
                    String cateID = rs.getString("cateID");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String year = rs.getString("year");
                    String title = rs.getString("title");
                    String image = rs.getString("image");
                    CarDTO dto = new CarDTO(carID, color, carName, price, quantity, year, title, image,cateID);
                    list.add(dto);
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

    public List<CarDTO> searchCar(Date rentDate, Date retuDate, String name, int amount) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CarDTO> list = new ArrayList();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select Car.carID, Car.carName,Car.price,Car.quantity,Car.color,Car.title,Car.year,Car.image,Car.cateID,RentDetails.dateRent,RentDetails.dateTerm,RentDetails.quantity as rtQuantity "
                        + "From Car left join RentDetails on Car .carID = RentDetails.carID "
                        + "Where Car.quantity > RentDetails.quantity or RentDetails.quantity is  null and Car.carName Like ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String carName = rs.getString("carName");
                    float price = rs.getFloat("price");
                    String color = rs.getString("color");
                    String title = rs.getString("title");
                    String year = rs.getString("year");
                    String image = rs.getString("image");
                    int quantity = rs.getInt("quantity");
                    String cateID = rs.getString("cateID");
                    CarDTO dto = new CarDTO(carID, color, carName, price, quantity, year, title, image,carID);

                    Date daterent = rs.getDate("dateRent");
                    
                    Date dateterm = rs.getDate("dateTerm");
                    
                    int rentquanity = rs.getInt("rtQuantity");

                    if ((quantity - rentquanity) >= amount) {
                        if (daterent == null && dateterm == null) {
                            list.add(dto);
                        } else {
                            if ((rentDate.compareTo(daterent) < 0 && rentDate.compareTo(dateterm) < 0) || (rentDate.compareTo(daterent) > 0 && rentDate.compareTo(dateterm) > 0)) {
                                list.add(dto);
                            } else {
                                if (rentquanity > quantity) {
                                    list.add(dto);
                                }
                            }
                        }
                    }

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

    public int getQuantityByCarId(String carID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select quantity "
                        + "From Car "
                        + "Where carID = ?";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int quatity = rs.getInt("quantity");
                    return quatity;
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
        return 0;
    }
    
    public List<CarDTO> searchCarByCate(Date rentDate, Date retuDate, int amount,String categoID) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CarDTO> list = new ArrayList();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select Car.carID, Car.carName,Car.price,Car.quantity,Car.color,Car.title,Car.year,Car.image,Car.cateID,RentDetails.dateRent,RentDetails.dateTerm,RentDetails.quantity as rtQuantity "
                        + "From Car left join RentDetails on Car .carID = RentDetails.carID "
                        + "Where Car.cateID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, categoID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String carName = rs.getString("carName");
                    float price = rs.getFloat("price");
                    String color = rs.getString("color");
                    String title = rs.getString("title");
                    String year = rs.getString("year");
                    String image = rs.getString("image");
                    int quantity = rs.getInt("quantity");
                    String cateID = rs.getString("cateID");
                    CarDTO dto = new CarDTO(carID, color, carName, price, quantity, year, title, image, cateID);

                    Date daterent = rs.getDate("dateRent");

                    Date dateterm = rs.getDate("dateTerm");

                    int rentquanity = rs.getInt("rtQuantity");
                    System.out.println("rent quantiy la:" + rentquanity);

                    if ((quantity - rentquanity) >= amount) {
                        if (daterent == null && dateterm == null) {
                            list.add(dto);
                        } else {
                            if ((rentDate.compareTo(daterent) < 0 && rentDate.compareTo(dateterm) < 0) || (rentDate.compareTo(daterent) > 0 && rentDate.compareTo(dateterm) > 0)) {
                                list.add(dto);
                            } else {
                                if (rentquanity < quantity) {
                                    list.add(dto);
                                }
                            }
                        }
                    }
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
    
    public List<CarDTO> getHomeCar() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CarDTO> list = new ArrayList();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select top 5 carID, color, carName, cateID, price, quantity, year, title, image "
                        + "From Car "
                        + "Where carID not in (Select top 0 carID From Car) "
                        + "ORDER BY carID ";
                
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String color = rs.getString("color");
                    String carName = rs.getString("carName");
                    String cateID = rs.getString("cateID");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String year = rs.getString("year");

                    String title = rs.getString("title");
                    String image = rs.getString("image");
                    CarDTO dto = new CarDTO(carID, color, carName, price, quantity, year, title, image,cateID);
                    list.add(dto);
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
    
    public List<CarDTO> getPaging(int pageSize, int index) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CarDTO> list = new ArrayList();
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select carID, color, carName, cateID, price, quantity, year, title, image "
                        + "From Car "                        
                        + "ORDER BY carID "
                        + "OFFSET ? ROWS "
                        + "FETCH NEXT ? ROWS ONLY";
                
                stm = con.prepareStatement(sql);
                stm.setInt(1, (pageSize*index-pageSize));
                stm.setInt(2, pageSize);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String color = rs.getString("color");
                    String carName = rs.getString("carName");
                    String cateID = rs.getString("cateID");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String year = rs.getString("year");

                    String title = rs.getString("title");
                    String image = rs.getString("image");
                    CarDTO dto = new CarDTO(carID, color, carName, price, quantity, year, title, image,cateID);
                    list.add(dto);
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
