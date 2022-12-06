/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.web;

import co.com.domain.Address;
import co.com.domain.Contact;
import co.com.domain.Student;
import co.com.service.EntityService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jpatarroyo
 */
public class ServletModify extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @param modify
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, boolean modify)
            throws ServletException, IOException {
        if (modify) {
            String delete = request.getParameter("delete");
            if (delete != null && delete.equals("Delete")) {
                deleteStudent(request, response);
                return;
            }
            modifyStudent(request, response);
            return;
        }
        // Search student
        String id = request.getParameter("id");
        Student student = new Student(Integer.parseInt(id));
        EntityService<Student> service = new EntityService<>(Student.class);
        student = service.getSpecificObject(student, student.getIdStudent());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("student", student);
        request.getRequestDispatcher("/WEB-INF/student/modifyStudent.jsp").forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void modifyStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Student student = (Student) sesion.getAttribute("student");
        Integer idStudent = student.getIdStudent();
        // Setting vars
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String street = request.getParameter("street");
        String numberStreet = request.getParameter("numberStreet");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Address address = new Address(street, numberStreet, country);
        Contact contact = new Contact(phone, email);
        student = new Student(idStudent, address, contact, name, lastName);
        EntityService<Student> studentService = new EntityService<>(Student.class);
        // Saving object
        EntityService<Student> service = new EntityService<>(Student.class);
        service.saveObject(student);
        // Removing attributes
        sesion.removeAttribute("student");
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Student student = new Student(Integer.parseInt(request.getParameter("id")));
        EntityService<Student> studentService = new EntityService<>(Student.class);
        EntityService<Student> service = new EntityService<>(Student.class);
        service.deleteObject(student);
        sesion.removeAttribute("student");
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(System.err);
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
        processRequest(request, response, false);
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
        processRequest(request, response, true);
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
