/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.model.Posting;
import java.service.WebLogService;

/**
 *
 * @author pc
 */
@WebServlet("/log")
public class ControllerServlet extends HttpServlet {

    private WebLogService web;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//SetAttributess
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String toPost = request.getParameter("topost");

        Posting p = new Posting(title, toPost);
        web.addPosting(p);
        System.out.println("WORKED!!");

        request.getRequestDispatcher("WebLogAdmin.jsp").forward(request, response);
    }
}
