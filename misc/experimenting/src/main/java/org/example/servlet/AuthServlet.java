package org.example.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.AppUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // hardcoded users

        List<AppUser> users = new ArrayList<>();

        users.add(new AppUser(1, "John", "Smith", "jsmith@revature.com", "jsmith", "testpass"));
        users.add(new AppUser(2, "Jane", "Doe", "jd42@revature.com", "jd42", "testpass"));
        users.add(new AppUser(3, "Johnny", "Smith", "jsmith@revature.com", "jsmith1", "testpass"));
        users.add(new AppUser(4, "Jimmy", "Smith", "jsmith@revature.com", "jsmith2", "testpass"));
        users.add(new AppUser(5, "Jorghan", "Smith", "jsmith@revature.com", "jsmith3", "testpass"));


        // im going to construct a new hashmap to store the credential login information

        HashMap<String, Object> credentials = mapper.readValue(req.getInputStream(), HashMap.class);

        //we'll essentially extract the information from this map
        String providedUsername = (String) credentials.get("username");
        String providedPassword = (String) credentials.get("password");

        //System.out.println(providedUsername + providedPassword);

        for (AppUser user: users){
            if (providedUsername.equals(user.getUsername()) && providedPassword.equals(user.getPassword())){
                System.out.println("found user");

                /*
                http is a stateless protocol, which means that no information is shared amongst requests
                so, to persist that data of who is logged in, we need to create a session
                 */

                HttpSession session = req.getSession();
                // this will create a session if one does not exist yet

                session.setAttribute("auth-user", mapper.writeValueAsString(user));

                resp.setStatus(204);
                return;
            }
        }

        resp.setStatus(400);
        resp.setContentType("application/json");

        HashMap<String, Object> errorMsg = new HashMap<>();
        errorMsg.put("Error code", 400);
        errorMsg.put("Message", "No user found with provided credentials");
        errorMsg.put("Timestamp", LocalDateTime.now().toString());

        resp.getWriter().write(mapper.writeValueAsString(errorMsg));

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null){
            AppUser user = mapper.readValue((String) session.getAttribute("auth-user"), AppUser.class);
            System.out.println(user.getUsername());
            session.invalidate();
        }

        resp.setStatus(204);
    }
}
