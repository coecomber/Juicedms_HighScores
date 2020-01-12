package com.Herwaarden.HighScores;


import com.Herwaarden.HighScores.Logic.HighscoresLogic;
import com.Herwaarden.HighScores.Model.HighScoreModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class HighScoresApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	//Integration test
	@Test
	void TestGettingHighestPoweredPlayer() throws Exception {
		HighscoresLogic highscoresLogic = new HighscoresLogic();

		mockMvc.perform(get("/public/highscores/get/{amount}", 1)
				.contentType("application/json"));

		List<HighScoreModel> highScoreModelList = highscoresLogic.getTopHighscoresByAmount(1);
		System.out.println(highScoreModelList + " = highscoresModelList");
		for( HighScoreModel currentHighScoreModel : highScoreModelList){
			assertThat(currentHighScoreModel.getName()).isEqualTo("Juiced");
			assertThat(currentHighScoreModel.getPower()).isAtLeast(10);
		}
	}
}
