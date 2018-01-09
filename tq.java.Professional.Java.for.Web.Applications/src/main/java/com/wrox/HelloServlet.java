package com.wrox;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class HelloServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        System.err.println("HelloServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getInputStream()
        resp.getWriter().println("Hello, World!! hahahaTQ");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        resp.addCookie(new Cookie("name","tq"));
        resp.setContentType();
        resp.getWriter().println("res");
    }

    @Override
    public void destroy() {
        System.err.println("HelloServlet destroy");
    }
}
