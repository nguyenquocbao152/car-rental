/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.servlet;

import baonq.car.CarDAO;
import baonq.car.CarDTO;
import baonq.car.CarError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
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
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

    private static final String ERROR = "Home.jsp";
    private static final String SUCCESS = "Home.jsp";

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
        CarDAO dao = new CarDAO();
        boolean err = false;
        CarError errObj = new CarError();
        String url = ERROR;
        try {
            String name = request.getParameter("txtName");

            String cate = request.getParameter("Category");
            System.out.println("cate la:" + cate);
            String rentalDate = request.getParameter("txtRetalDate");

            String returnDate = request.getParameter("txtReturnDate");
            String amount = request.getParameter("txtAmount");

            if (!amount.matches("\\d+")) {
                err = true;
                errObj.setAmount("vui long nhap so luong la so");
            }
            request.setAttribute("ERROR", errObj);
            if (err) {
                url = ERROR;
            } else {
                HttpSession session = request.getSession();
                Date rentdate = Date.valueOf(rentalDate);
                System.out.println("ngay thue la:" + rentalDate);
                Date retuDate = Date.valueOf(returnDate);
                System.out.println("ngay tra la:" + returnDate);
                int soLuong = Integer.parseInt(amount);
                session.setAttribute("RENTDATE", rentdate);
                session.setAttribute("RETURNDATE", retuDate);

                if (name != null && cate!=null) {
                    List<CarDTO> listn = dao.searchCar(rentdate, retuDate, name, soLuong);                    
                    session.setAttribute("listCar", listn);
                    url = SUCCESS;
                }
                
                if(name.length()<=0 && cate!=null){
                    List<CarDTO> listc = dao.searchCarByCate(rentdate, retuDate, soLuong, cate);
                    
                    request.setAttribute("listCar", listc);
                    url = SUCCESS;
                }
                
            }

        } catch (SQLException ex) {
            log("SearchServlet SQL:" + ex.getMessage());
        } catch (NamingException ex) {
            log("SearchServlet Naming:" + ex.getMessage());
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
