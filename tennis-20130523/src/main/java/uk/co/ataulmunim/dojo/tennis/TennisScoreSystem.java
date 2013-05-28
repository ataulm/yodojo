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
     * Constructor for a new game using the Tennis Score System
     */
    public TennisScoreSystem() {
        scoreA = 0;
        scoreB = 0;
    }

    /**
     * Constructor allowing the scores to be initialised (continuing a game
     * after rain delay).
     *
     * @param scoreA score for Player A
     * @param scoreB score for Player B
     */
    public TennisScoreSystem(int scoreA, int scoreB) {
        boolean validScore = true;

        if (scoreA < 0 || scoreB < 0) validScore = false;
        if ((scoreA > 3 || scoreB > 3) && Math.abs(scoreB-scoreA) > 2) validScore = false;

        if (validScore) {
            this.scoreA = scoreA;
            this.scoreB = scoreB;

        } else {
            this.scoreA = 0;
            this.scoreB = 0;
            System.out.println("Invalid parameters; score initialised at 0-0");
        }
    }

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

    /**
     * Increments score for the specified player by one point.
     *
     * @param player
     * @return the score after the point has been incremented or -1 if the specified player doesn't exist.
     */
    public int incrementScore(int player) {
        switch (player) {
            case PLAYER_A:
                return ++scoreA;
            case PLAYER_B:
                return ++scoreB;
        }
        return -1;
    }



}
