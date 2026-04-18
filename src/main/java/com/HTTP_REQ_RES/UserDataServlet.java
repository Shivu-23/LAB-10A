package com.HTTP_REQ_RES;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/processUser")
public class UserDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");

        String message = "";

        // Server-side validation
        if (username == null || username.trim().isEmpty()) {
            message = "Error: Username is required!";
        } 
        else if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            message = "Error: Invalid Email!";
        } 
        else if (designation == null || designation.trim().isEmpty()) {
            message = "Error: Designation is required!";
        } 
        else {
            message = "User data processed successfully!";

            // Set attributes
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("designation", designation);
        }

        request.setAttribute("message", message);

        // Forward to result page
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}