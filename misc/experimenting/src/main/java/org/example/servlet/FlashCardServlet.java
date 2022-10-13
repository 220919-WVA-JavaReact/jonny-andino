package org.example.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.FlashCardDAO;
import org.example.dao.FlashCardDAOImpl;
import org.example.model.FlashCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@WebServlet(
        urlPatterns = "/flashcard",
        initParams = {
                @WebInitParam(name="flashcard-servlet-key", value="flashcard-servlet-value"),
                @WebInitParam(name="another-key", value="another-value")
        })
public class FlashCardServlet extends HttpServlet {
    // this is bad practice since we need to create some sort of objectmapper every time we create a servlet
    private final ObjectMapper mapper = new ObjectMapper();

    private final FlashCardDAO fd = new FlashCardDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlashCard> cards = fd.getCards();

        String respPayload = mapper.writeValueAsString(cards);
        resp.setContentType("application/json");
        resp.getWriter().write(respPayload);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // the user needs to be logged in to create a new flashcard
        // we want to verify that the user is logged in to do this

        HttpSession session = req.getSession(false); // if they don't have a session do not make one!

        // check the session

        if (session == null){
            HashMap<String, Object> errorMsg = new HashMap<>();
            errorMsg.put("Error code", 400);
            errorMsg.put("Message", "No user found with provided credentials");
            errorMsg.put("Timestamp", LocalDateTime.now().toString());

            resp.getWriter().write(mapper.writeValueAsString(errorMsg));
            return;
        }

        // this is where we might call upon the svc layer and eventually persist the card to the db
    }
}
