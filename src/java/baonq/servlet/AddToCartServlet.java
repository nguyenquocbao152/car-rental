/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.servlet;

import baonq.car.CarDAO;
import baonq.car.CarDTO;
import baonq.items.Item;
import baonq.order.OrderDTO;
import baonq.rentaldetails.RentDetailDAO;
import baonq.rentaldetails.RentDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String carID = request.getParameter("carID");
        String rent = request.getParameter("rent");
        System.out.println("carID la:" + carID);
        CarDAO dao = new CarDAO();  
        RentDetailDAO rtd = new RentDetailDAO();
        try {            
            int quantity = 1;
            if (carID != null) {
                CarDTO dto = dao.getCarByID(carID);
                RentDetails rt = rtd.getQuantyRent(carID);
                int amountRented = 0;
                if(rt!=null){
                    amountRented = rt.getQuantity();
                    System.out.println("quantity la:"+amountRented); 
                }
                
                if (dto != null) {
                    
                    System.out.println(dto.toString());
                    HttpSession session = request.getSession();
                    if (session.getAttribute("order") == null) {
                        OrderDTO order = new OrderDTO();
                        List<Item> list = new ArrayList();
                        Date rentDate = (Date) session.getAttribute("RENTDATE");
                        Date returDate = (Date) session.getAttribute("RETURNDATE");

                        Item item = new Item();
                        item.setCar(dto);
                        item.setQuantity(quantity);
                        item.setPrice(dto.getPrice());
                        item.setRentDate(rentDate);
                        item.setReturnDate(returDate);
                        item.setAmountRented(amountRented);
                        list.add(item);
                        order.setList(list);
                        session.setAttribute("order", order);

                    } else {
                        OrderDTO order = (OrderDTO) session.getAttribute("order");
                        List<Item> list = order.getList();
                        boolean check = false;
                        for (Item item : list) {
                            if (item.getCar().getCarID().equals(dto.getCarID())) {
                                item.setQuantity(item.getQuantity() + quantity);
                                check = true;
                            }
                        }
                        if (check == false) {

                            Date rentDate = (Date) session.getAttribute("RENTDATE");
                            Date returDate = (Date) session.getAttribute("RETURNDATE");
                            Item item = new Item();
                            item.setQuantity(quantity);
                            item.setCar(dto);
                            item.setPrice(dto.getPrice());
                            item.setRentDate(rentDate);
                            item.setReturnDate(returDate);
                            list.add(item);

                        }
                        session.setAttribute("order", order);                       
                    }
                }
            }

        } catch (SQLException ex) {
            log("AddToCartServlet SQL:" + ex.getMessage());
        } catch (NamingException ex) {
            log("AddToCartServlet Naming:" + ex.getMessage());
        } finally {
            request.getRequestDispatcher("HomeServlet").forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
