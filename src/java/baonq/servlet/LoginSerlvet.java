/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.servlet;

import baonq.account.AccountDAO;
import baonq.account.AccountDTO;
import baonq.constans.VerifyUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "LoginSerlvet", urlPatterns = {"/LoginServlet"})
public class LoginSerlvet extends HttpServlet {

    private static final String ERROR = "login2.jsp";
    private static final String SUCESS = "HomeServlet";
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
        AccountDAO dao = new AccountDAO();
        String url = ERROR;
        boolean valid = true;
        String errorString = null;
        try {
            String userID = request.getParameter("txtEmail");
            System.out.println("userID la :" + userID);
            String password = request.getParameter("txtPassword");
            System.out.println("password la :" + userID);
            AccountDTO dto = dao.checkLogin(userID, password);
            if (dto == null) {
                valid = false;
                errorString = "Email or Password invalid!";
            }
            if (valid) {

                String gRecaptchaResponse = request.getParameter("g-recaptcha-response");

                System.out.println("gRecaptchaResponse=" + gRecaptchaResponse);

                // Verify CAPTCHA.
                valid = VerifyUtils.verify(gRecaptchaResponse);
                if (!valid) {
                    errorString = "Captcha invalid!";
                }
            }
            if (!valid) {
                request.setAttribute("errorString", errorString);
                url = ERROR;               
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("ACCOUNT", dto);
                url = SUCESS;
            }

        } catch (NamingException ex) {
            log("LoginSerlvet Naming:" + ex.getMessage());
        } catch (SQLException ex) {
            log("LoginSerlvet SQL:" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
