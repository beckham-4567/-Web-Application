/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package services;

import Default.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import model.Store;
import org.json.JSONObject;

public class getStoreDataService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String requestUrl = request.getRequestURI();
        String name = requestUrl.substring("/Lab07/getStoreDataService/".length());        
       
        name = URLDecoder.decode( name, "UTF-8" );
        System.out.println(">>>>>>>>>>getStoreDataService: name=" + name);
        
        // retrieve food from MySQL: table food
        DBConnection dbConnection = new DBConnection();
//        String name = "ยำหมูยอ"; 
        Store store = dbConnection.getStore(name);

        if (store != null) {
            String json = "{\n";
            json += "\"name\": " + JSONObject.quote(store.getName()) + ",\n";
            json += "\"type\": " + JSONObject.quote(store.getType()) + ",\n";
            json += "\"spicy\": " + JSONObject.quote(store.getFilter()) + "\n";
            json += "\"spicy\": " + JSONObject.quote(store.getPopularity()) + "\n";
            json += "\"price\": " + JSONObject.quote(Integer.toString(store.getPrice())) + "\n";
            json += "}";
            // ERROR: java.io.CharConversionException: Not an ISO 8859-1 character:
//            response.getOutputStream().println(json);
            // ต้องใช้ response.getWriter()
            response.getWriter().print(json);
        } else {
//            response.getOutputStream().println("{}");
            response.getWriter().print("");
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
