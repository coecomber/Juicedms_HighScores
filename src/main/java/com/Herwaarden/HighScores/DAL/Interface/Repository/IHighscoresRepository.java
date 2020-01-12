package com.Herwaarden.HighScores.DAL.Interface.Repository;

import com.Herwaarden.HighScores.Model.HighScoreModel;
import java.util.List;

public interface IHighscoresRepository {
    List<HighScoreModel> getCharactersOrderedByPowerDesc();
}
