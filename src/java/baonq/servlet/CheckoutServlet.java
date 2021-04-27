/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.servlet;

import baonq.account.AccountDTO;
import baonq.items.Item;
import baonq.order.OrderDTO;
import baonq.rentaldetails.RentDetailDAO;
import baonq.rentaldetails.RentDetails;
import baonq.rentals.RentalDAO;
import baonq.rentals.RettalDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {

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
        String derID ="RT";
        int so = 11;
        String rentID = derID+"-"+so;
        boolean flag = true;
        RentalDAO dao = new RentalDAO();
        String tota = request.getParameter("total");
        float total = Float.parseFloat(tota);
        System.out.println("total la:"+tota);
        RentDetailDAO rtd = new RentDetailDAO();
        try {           
            HttpSession session = request.getSession();
            OrderDTO order = (OrderDTO) session.getAttribute("order");
            List<Item> list = order.getList();
            AccountDTO acc = (AccountDTO)session.getAttribute("ACCOUNT");
            while(flag){
                RettalDTO dto = dao.checkDuplicate(rentID);
                if(dto!=null){
                    so++;
                    rentID = derID+"-"+so;
                    System.out.println("rentID la:"+rentID);
                }else{
                    dao.insertRental(rentID, acc.getEmail(), total);
                    for(Item item:list){
                        RentDetails rd = new RentDetails(rentID, item.getCar().getCarID(), item.getRentDate(),item.getReturnDate(), item.getPrice(),item.getQuantity());
                        rtd.insert(rd);
                    }
                    flag = false;
                }
            }
            
        } catch (NamingException ex) {
            log("CheckoutSerlvet Naming:"+ex.getMessage());
        } catch (SQLException ex) {
            log("CheckoutSerlvet SQL:"+ex.getMessage());
        } finally {
            request.getRequestDispatcher("Home.jsp").forward(request, response);
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
