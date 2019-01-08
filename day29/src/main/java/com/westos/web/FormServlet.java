package com.westos.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/myform")
public class FormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root")){
            try(PreparedStatement ps = conn.prepareStatement("insert into user(username,password) values( ?, ?);\n")){
                if(username.matches("[a-zA-Z]\\w{4,16}") && password.matches("\\w{6}")){
                    ps.setString(1,username);
                    ps.setString(2,password);
                    int rows = ps.executeUpdate();
                    System.out.println("影响的行数是："+rows);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
