package uk.co.ataulmunim.dojo.tennis;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by ataulm on 24/05/13.
 */
public class TennisScoreSystemShould {

    private final TennisScoreSystem scoreSystem = new TennisScoreSystem();

    @Test
    public void start_with_score_tied_at_love_all() {
        assertThat(scoreSystem.getScore(TennisScoreSystem.PLAYER_A), is(0));
        assertThat(scoreSystem.getScore(TennisScoreSystem.PLAYER_B), is(0));
    }
}
