package uk.co.ataulmunim.dojo.tennis;

import org.junit.Test;

import static uk.co.ataulmunim.dojo.tennis.TennisScoreSystem.*;
import static uk.co.ataulmunim.dojo.tennis.TennisScoreSystem.ScoreValues.*;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by ataulm on 24/05/13.
 */
public class TennisScoreSystemShould {

    private final TennisScoreSystem scoreSystem = new TennisScoreSystem();

    @Test
    public void start_with_score_tied_at_love_all() {
        assertThat(scoreSystem.getScore(PLAYER_A), is(LOVE));
        assertThat(scoreSystem.getScore(PLAYER_B), is(LOVE));
    }

    @Test
    public void return_tennis_score_in_words() {
        assertThat(scoreSystem.getScore(PLAYER_A), anyOf(is(LOVE), is(FIFTEEN), is(THIRTY), is(FORTY), is(ADVANTAGE)));
        assertThat(scoreSystem.getScore(PLAYER_B), anyOf(is(LOVE), is(FIFTEEN), is(THIRTY), is(FORTY), is(ADVANTAGE)));
    }
}
