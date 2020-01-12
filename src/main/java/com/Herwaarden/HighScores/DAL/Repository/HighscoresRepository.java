package com.Herwaarden.HighScores.DAL.Repository;

import com.Herwaarden.HighScores.DAL.Interface.Context.IHighscoresContext;
import com.Herwaarden.HighScores.DAL.Interface.Repository.IHighscoresRepository;
import com.Herwaarden.HighScores.Model.HighScoreModel;

import java.util.List;

public class HighscoresRepository implements IHighscoresRepository {

    private IHighscoresContext highscoresContext;

    public HighscoresRepository(IHighscoresContext context){
        highscoresContext = context;
    }

    @Override
    public List<HighScoreModel> getCharactersOrderedByPowerDesc() {
        return highscoresContext.getCharactersOrderedByPowerDesc();
    }
}
