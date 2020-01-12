package com.Herwaarden.HighScores.DAL.Context;

import com.Herwaarden.HighScores.DAL.Interface.Context.IHighscoresContext;
import com.Herwaarden.HighScores.Model.HighScoreModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HighscoresContextSQL implements IHighscoresContext {
    private String sqlUrl;
    private String usernameUrl;
    private String passwordUrl;

    // Constructors
    public HighscoresContextSQL(){
        sqlUrl = "jdbc:mysql://217.101.44.31/characterDB";
        usernameUrl = "root";
        passwordUrl = "varken";
    }

    // Methods
    @Override
    public List<HighScoreModel> getCharactersOrderedByPowerDesc() {
        List<HighScoreModel> highScoresToReturn = new ArrayList<>();

        // create our mysql database connection
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "SELECT * FROM charactertable ORDER BY POWER DESC";

            // create the java statement
            try (Statement st = conn.createStatement())
            {
                try (ResultSet rs = st.executeQuery(query))
                {
                    // iterate through the java resultset
                    while (rs.next())
                    {
                        HighScoreModel highScoreModel = new HighScoreModel();
                        highScoreModel.setName(rs.getString("name"));
                        highScoreModel.setPower(rs.getInt("power"));

                        highScoresToReturn.add(highScoreModel);
                    }
                }
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in HighscoresContextSQL.getTopHighscoresByAmount().");
            System.err.println(e.getMessage());
        }

        return highScoresToReturn;
    }


}
