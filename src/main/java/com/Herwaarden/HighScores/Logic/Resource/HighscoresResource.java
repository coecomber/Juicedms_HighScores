package com.Herwaarden.HighScores.Logic.Resource;

import com.Herwaarden.HighScores.Logic.HighscoresLogic;
import com.Herwaarden.HighScores.Model.HighScoreModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class HighscoresResource {

    // How to make REST at least level 2:
    // https://martinfowler.com/articles/richardsonMaturityModel.html#level0

    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @GetMapping("/public/highscores/get/{amount}")
    public List<HighScoreModel> getHighscoresPublic(@PathVariable("amount") int amount){
        HighscoresLogic highscoresLogic = new HighscoresLogic();

        return highscoresLogic.getTopHighscoresByAmount(amount);
    }
}
