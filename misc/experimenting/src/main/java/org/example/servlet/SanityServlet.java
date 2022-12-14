package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

// whenever we want to create a servlet we will extend the HttpServlet
public class SanityServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG] - SanityServlet was instantiated");
        System.out.println("[LOG] - Init param test-init-key: " + this.getServletConfig().getInitParameter("test-init"));
        System.out.println("[LOG] - Context param test-context-key: " + this.getServletContext().getInitParameter("test-context-key"));
    }

    @Override
    public void destroy() {
        System.out.println("[LOG] - SanityServlet was destroyed");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // we'll just add some println statements to check some info about the request
        System.out.println("[LOG] - SanityServlet received a request at " + LocalDateTime.now());
        System.out.println("[LOG] - Request URI: " + req.getRequestURI());
        System.out.println("[LOG] - Request Method: " + req.getMethod());
        System.out.println("[LOG] - Request Header, example: " + req.getHeader("example"));
        System.out.println("[LOG] - Request Query String: " + req.getQueryString());

        System.out.println("[LOG] - was filtered? " + req.getAttribute("was-filtered"));

        // we'll formulate a basic response to send back

        // set the status code
        resp.setStatus(200);
        resp.setHeader("Content-type", "text/plain");
        resp.setHeader("example-response-header", "some-example-value");
        resp.getWriter().write("Hello from servlet!");
    }
}