package com.week10;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Book book = new Book("Java Programming", "James Gosling", 550.0);
        User user = new User("Nandini", "nandini@gmail.com", "12345");

        session.persist(book);
        session.persist(user);

        tx.commit();
        session.close();

        out.println("<h1>Hibernate Entity Mapping Successful</h1>");
        out.println("<h2>Book and User data inserted successfully!</h2>");
    }
}