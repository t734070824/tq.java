package com.wrox;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        System.err.println("HelloServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Hello, World!! hahahaTQ");
    }

    @Override
    public void destroy() {
        System.err.println("HelloServlet destroy");
    }
}
