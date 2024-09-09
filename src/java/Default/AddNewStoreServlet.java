/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Default;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Store;

@WebServlet(urlPatterns = {"/addNewStoreServlet"})
public class AddNewStoreServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String storeName = request.getParameter("storeName");
        String storeType = request.getParameter("storeType");
        String storeFilter = request.getParameter("storeFilter");
        String storePopularity = request.getParameter("storePopularity");
        int price = Integer.parseInt(request.getParameter("storePrice"));

        Store store = new Store();
        store.setName(storeName);
        store.setType(storeType);
        store.setFilter(storeFilter);
        store.setPopularity(storePopularity);
        store.setPrice(price);

        DBConnection dbConnection = new DBConnection();
        if (!dbConnection.insertNewStore(store)) {
            System.out.println(">>> AddNewStoreMySQL ERROR");
        }

        HttpSession session = request.getSession();
        session.setAttribute("store", store);

        request.getRequestDispatcher("/addNewStoreSuccess.jsp").forward(request, response);
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
