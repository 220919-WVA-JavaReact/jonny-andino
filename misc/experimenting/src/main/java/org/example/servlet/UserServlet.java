package org.example.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.AppUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(value = "/user")
public class UserServlet extends HttpServlet {

    // TODO what is the other servlets need an objectMapper? how do we share this reference among classes?
    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG] - UserServlet received a GET request at " + LocalDateTime.now());
        //when we did our post request we parsed a json string into a java object. now to do the reverse.
        AppUser someUser = new AppUser(123,"jane","doe","jd42@revature.com","jd42","password");
        // we want to convert this java object into some sort of JSON string

        String respPayload = mapper.writeValueAsString(someUser);

        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getWriter().write(respPayload);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // post requests are generally used for the creation of data in an application
        System.out.println("[LOG] - UserServlet received a POST request at " + LocalDateTime.now());

        // to print out from our inputstream
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        // String line;
        // while ((line = bufferedReader.readLine()) != null){
        //     System.out.println(line);
        // }
        AppUser newUser = mapper.readValue(req.getInputStream(), AppUser.class);
        // at this point newUser could be sent to svc layer -> DAO layer -> ect ect
        System.out.println(newUser);
        resp.setStatus(204);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
