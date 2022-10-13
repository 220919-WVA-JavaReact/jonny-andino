package org.example.dao;

import org.example.model.FlashCard;
import org.example.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlashCardDAOImpl implements FlashCardDAO{

    // this is where our jdbc will go in just a few.
    @Override
    public List<FlashCard> getCards() {
        // list to store our info

        List<FlashCard> cards = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM flashcards";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                // create new flashcard object
                FlashCard card = new FlashCard();
                card.setId(rs.getInt("id"));
                card.setQuestionText(rs.getString("question_text"));
                card.setAnswerText(rs.getString("answer_text"));

                //add to collection

                cards.add(card);
            }
        } catch (SQLException e) {
            System.err.println("An error occurred within FlashCardDAOImpl.getCards()");
            e.printStackTrace();
        }

        return cards;
    }
}
