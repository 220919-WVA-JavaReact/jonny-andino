package org.example.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.FlashCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = "/flashcard",
        loadOnStartup = 3,
        initParams = {
                @WebInitParam(name="flashcard-servlet-key", value="flashcard-servlet-value"),
                @WebInitParam(name="another-key", value="another-value")
        })
public class FlashCardServlet extends HttpServlet {
    // this is bad practice since we need to create some sort of objectmapper every time we create a servlet
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // pretend this value came from the db
        FlashCard card = new FlashCard(123,"What does oop stand for", "Object Oriented Programming");
        String respPayload = mapper.writeValueAsString(card);
        resp.setContentType("application/json");
        resp.getWriter().write(respPayload);
    }
}
