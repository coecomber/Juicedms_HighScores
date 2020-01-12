package com.Herwaarden.HighScores.Factory;

import com.Herwaarden.HighScores.DAL.Context.HighscoresContextSQL;
import com.Herwaarden.HighScores.DAL.Interface.Repository.IHighscoresRepository;
import com.Herwaarden.HighScores.DAL.Repository.HighscoresRepository;

public class HighscoresFactory {
    public HighscoresRepository highscoresRepository;

    public IHighscoresRepository getHighscoresSQLRepository(){
        highscoresRepository = new HighscoresRepository(new HighscoresContextSQL());
        return highscoresRepository;
    }

}
