package uk.co.ataulmunim.dojo.tennis;

/**
 * Created by ataulm on 24/05/13.
 */
public class TennisScoreSystem {
    public static final int PLAYER_A = 0;
    public static final int PLAYER_B = 1;

    private int scoreA;
    private int scoreB;

    /**
     * Returns score for the requested player, or -1 if no players were
     * matched.
     *
     * @param player id of the player corresponding to PLAYER_A or PLAYER_B
     *
     * @return score
     */
    public int getScore(int player) {
        switch (player) {
            case PLAYER_A:
                return scoreA;
            case PLAYER_B:
                return scoreB;
        }
        return -1;
    }



}
