/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PostingDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Comment;
import model.Posting;
import service.WebLogService;

/**
 *
 * @author pc
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/log", "/admin", "/posting", "/changeUser"})
public class ControllerServlet extends HttpServlet {

    WebLogService web = new WebLogService();
    PostingDaoImp dao = new PostingDaoImp();

    List<Comment> comments = new ArrayList<>();

    public boolean status = true;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();

        if (status == true) {
            session.setAttribute("mode", "admin");
            status = false;
        }
        if (userPath.equals("/log")) {
            List<Posting> postings = web.getPostings();
            request.setAttribute("postings", postings);
            Date date = new Date();
            request.setAttribute("date", date.toString());
            RequestDispatcher view = request.getRequestDispatcher("WebLog.jsp");
            view.forward(request, response);
        } else if (userPath.equals("/admin")) {
//            if (session.getAttribute("mode").equals("admin")) {
                List<Posting> postings = web.getPostings();
                request.setAttribute("postings", postings);

                RequestDispatcher view = request.getRequestDispatcher("WebLogAdm.jsp");
                view.forward(request, response);
//            } else {
//                response.sendRedirect("log");
//            }

        } else if (userPath.equals("/posting")) {

            String Id = request.getParameter("hiddenId");
            System.out.println("HIDDENID: " + Id);
            List<Posting> postings = web.getPostings();
            for (Posting p : postings) {
                if (p.getId() == Long.parseLong(Id)) {
                    request.setAttribute("postingId", Id);
                    request.setAttribute("title", p.getTitle());
                    request.setAttribute("content", p.getContent());
                    comments = p.getComments();
                    request.setAttribute("comments", comments);
                    break;
                }
            }

            RequestDispatcher view = request.getRequestDispatcher("Posting.jsp");
            view.forward(request, response);
        }
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
        String userPath = request.getServletPath();
        System.out.println("USERPATH: " + userPath);
         if (request.getParameter("ChangeUserAction") != null) {
            swapMode(request);
            response.sendRedirect("log");
        }
         else if (userPath.equals("/admin")) {
            String title = request.getParameter("title");
            String toPost = request.getParameter("content");
            Posting p = new Posting(/*Long.parseLong(postId),*/title, toPost);
            web.addPosting(p);
            response.sendRedirect("log");

        } else if (userPath.equals("/posting")) {
            String comment = request.getParameter("newcomment");
            String Id = request.getParameter("postingId");
            System.out.println(comment);
            System.out.println(Id);
            Posting p = dao.find(Long.parseLong(Id));

            comments.add(new Comment(9L, comment));
            p.setComments(comments);
//            response.sendRedirect("log");
        } 
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

    public void swapMode(HttpServletRequest request) {
        HttpSession session = request.getSession();
        
        if (session.getAttribute("mode").equals("admin")) {
            session.setAttribute("mode", "user");
            request.setAttribute("mode", "user");
            System.out.println(session.getAttribute("mode"));
        } else if (session.getAttribute("mode").equals("user")) {
            session.setAttribute("mode", "admin");
            request.setAttribute("mode", "admin");
            System.out.println(session.getAttribute("mode"));

        }
    }
}
