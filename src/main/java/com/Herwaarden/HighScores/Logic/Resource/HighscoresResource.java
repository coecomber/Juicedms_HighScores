package com.Herwaarden.HighScores.Logic.Resource;

import com.Herwaarden.HighScores.Logic.HighscoresLogic;
import com.Herwaarden.HighScores.Model.HighScoreModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class HighscoresResource {

    // How to make REST at least level 2:
    // https://martinfowler.com/articles/richardsonMaturityModel.html#level0

    @GetMapping("/public/highscores/get/{amount}")
    public List<HighScoreModel> getHighscoresPublic(@PathVariable("amount") int amount){
        HighscoresLogic highscoresLogic = new HighscoresLogic();

        return highscoresLogic.getTopHighscoresByAmount(amount);
    }

    @GetMapping("/private/highscores/get/{amount}")
    public List<HighScoreModel> getHighscoresPrivate(@PathVariable("amount") int amount){
        HighscoresLogic highscoresLogic = new HighscoresLogic();

        return highscoresLogic.getTopHighscoresByAmount(amount);
    }
}
