package com.Herwaarden.HighScores.DAL.Interface.Context;

import com.Herwaarden.HighScores.Model.HighScoreModel;
import java.util.List;

public interface IHighscoresContext {
    List<HighScoreModel> getCharactersOrderedByPowerDesc();
}
