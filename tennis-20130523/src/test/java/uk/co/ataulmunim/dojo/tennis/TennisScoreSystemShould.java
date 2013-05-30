package uk.co.ataulmunim.dojo.tennis;

import org.junit.Test;

import static uk.co.ataulmunim.dojo.tennis.TennisScoreSystem.*;
import static uk.co.ataulmunim.dojo.tennis.TennisScoreSystem.ScoreValues.*;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;



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

    @Test
    public void increment_score_by_one_point_only() {
        int prior = scoreSystem.getScore(TennisScoreSystem.PLAYER_A);
        int post = scoreSystem.incrementScore(TennisScoreSystem.PLAYER_A);

        assertThat(post - prior, is(1));
    }

    /**
     * ASK: Should this be more exhaustive? Would one attempt have been enough to satisfy the test req?
     */
    @Test
    public void start_with_specified_score_if_given() {
        TennisScoreSystem scoreSystem = null;

        scoreSystem = new TennisScoreSystem(0,0);
        assertThat(scoreSystem.getScore(TennisScoreSystem.PLAYER_A), is(0));
        assertThat(scoreSystem.getScore(TennisScoreSystem.PLAYER_B), is(0));

        scoreSystem = new TennisScoreSystem(0,1);
        assertThat(scoreSystem.getScore(TennisScoreSystem.PLAYER_A), is(0));
        assertThat(scoreSystem.getScore(TennisScoreSystem.PLAYER_B), is(1));

        scoreSystem = new TennisScoreSystem(3,1);
        assertThat(scoreSystem.getScore(TennisScoreSystem.PLAYER_A), is(3));
        assertThat(scoreSystem.getScore(TennisScoreSystem.PLAYER_B), is(1));
    }

    /**
     * ASK: Can comparisons be tested using "assertThat" ?
     */
    @Test
    public void ensure_score_is_not_initialised_with_finished_game_values() {
        int tryScoreA = 3;
        int tryScoreB = 6;
        TennisScoreSystem scoreSystem = new TennisScoreSystem(tryScoreA, tryScoreB);

        int scoreA = scoreSystem.getScore(TennisScoreSystem.PLAYER_A);
        int scoreB = scoreSystem.getScore(TennisScoreSystem.PLAYER_B);

        // If a score is over 3 (== FORTY), and greater by 2 or more, then game is already over
        if (tryScoreA > 3 || tryScoreB > 3) assertTrue(Math.abs(scoreB - scoreA) < 2);
    }

    @Test
    public void ensure_score_is_not_initialised_with_negative_values() {
        TennisScoreSystem scoreSystem = new TennisScoreSystem(-1,1);

        int scoreA = scoreSystem.getScore(TennisScoreSystem.PLAYER_A);
        int scoreB = scoreSystem.getScore(TennisScoreSystem.PLAYER_B);

        assertTrue(scoreA >= 0);
        assertTrue(scoreB >= 0);
    }

    @Test
    public void reset_score_when_game_is_over() {

    }
}
