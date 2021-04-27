/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.servlet;

import baonq.account.AccountDAO;
import baonq.account.AccountDTO;
import baonq.account.AccountError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    private static final String ERROR = "register.jsp";
    private static final String SUCCESS = "login2.jsp";
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
        boolean err = false;
        AccountError errObj = new AccountError();
        AccountDAO dao = new AccountDAO();
        String url = ERROR;
        try{
            String email = request.getParameter("txtEmail");
            String fullname = request.getParameter("txtFullName");
            String address = request.getParameter("txtAddress");
            String phone = request.getParameter("txtPhone");
            String pass = request.getParameter("txtPassword");
            String confim = request.getParameter("txtCofirm");
            
            if(email.length()<=0){
                err = true;
                errObj.setEmailError("vui lòng điền vào trường này");
                System.out.println("1");
            }
            if(fullname.length()<=0){
                err = true;
                errObj.setNameError("vui lòng điền vào trường này");
                System.out.println("2");
            }
            if(phone.length()<=0){
                err= true;
                errObj.setPhoneError("vui lòng điền vào trường này");
            }
            if(pass.length()<=0){
                err = true;
                errObj.setPasError("vui lòng điền vào trường này");
                System.out.println("3");
            }
            if(confim.length()<=0){
                err = true;
                errObj.setConfirmError("vui lòng điền vào trường này");
                System.out.println("4");
            }
            if(!phone.matches("\\d{10}")){
                err =true;
                errObj.setPhoneError("vui lòng nhập phone là so va khong qua 10 ki tu");
            }
            if(!pass.equals(confim)){
                err = true;
                errObj.setConfirmError("Pass is not match with confirm");
            }
            
            AccountDTO acc = dao.checkDuplicate(email);
            if(acc!=null){
                err = true;
                errObj.setDulicateEmail(email+" is existed");
            }
            request.setAttribute("ERROR", errObj);
            if(err){
                url = ERROR;
            }else{
                long millis = System.currentTimeMillis();
                Date date = new Date(millis);
                AccountDTO dto = new AccountDTO(email, pass, fullname, phone, address,date,"New");
                dao.insert(dto);
                url = SUCCESS;
            }
        } catch (NamingException ex) {
            log("RegisterServlet Naming:"+ex.getMessage());
        } catch (SQLException ex) {
            log("RegisterServlet SQL:"+ex.getMessage());
        }finally{
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
