package com.Herwaarden.HighScores.Logic;

import com.Herwaarden.HighScores.DAL.Interface.Repository.IHighscoresRepository;
import com.Herwaarden.HighScores.Factory.HighscoresFactory;
import com.Herwaarden.HighScores.Model.HighScoreModel;

import java.util.ArrayList;
import java.util.List;

public class HighscoresLogic {
    private IHighscoresRepository highscoresRepository;

    public HighscoresLogic(){
        highscoresRepository = new HighscoresFactory().getHighscoresSQLRepository();
    }

    public List<HighScoreModel> getTopHighscoresByAmount(int amount){
        List<HighScoreModel> highScoreModelListToReturn = new ArrayList<>();

        List<HighScoreModel> allHighScores = highscoresRepository.getCharactersOrderedByPowerDesc();

        int currentCount = 1;
        for (HighScoreModel highScoreModel : allHighScores){
            if(currentCount <= amount){
                highScoreModelListToReturn.add(highScoreModel);
                currentCount++;
            } else {
                break;
            }
        }

        return highScoreModelListToReturn;
    }
}