
public class RPSGame {

    private int roundsTotal; // number of rounds to play
    private int roundsPlayed; // number of rounds that have completed
    private String roundWinner; // the winner of the current round
    private int oneWins; // number of rounds won by first player
    private int twoWins; // number of rounds won by second player
    private String oneMove; // first player's move
    private String twoMove; // second player's move
    private String winner; // which player won?

    /**
     * Constructs a RPS with a number of rounds wanted to be played
     * 
     * @param numRounds the number of rounds to be played
     */
    public RPSGame(int numRounds) {
        roundsTotal = numRounds;
    }

    /**
     * Uses private methods to play the game
     */
    public void playGame() {
    	initializeGame();
    	while(gameOver()== false){
    		advancePlay();
    		showGame();
    	}
    	judgeAndReport();
    }

    /**
     * initializes the variables, of the game
     */
    private void initializeGame() {
        roundsPlayed = 0;
        oneWins = 0;
        twoWins = 0;
        winner = "";
    }

    /**
     * Returns whether or not the game should be over
     * 
     * @return true or false of whether the specified amount of rounds has been played
     */
    private boolean gameOver() {
        return (roundsPlayed == roundsTotal);
    }

    /**
     * Determines the winner of each round
     */
    private void advancePlay() {
        roundsPlayed++;

        oneMove = chooseRPS();
        twoMove = chooseRPS();

        if ((oneMove.equals("Rock") && twoMove.equals("Scissors"))
                || (oneMove.equals("Scissors") && twoMove.equals("Paper"))
                || (oneMove.equals("Paper") && twoMove.equals("Rock"))) {
            oneWins++;
            roundWinner = "Player One";
        } else if ((twoMove.equals("Rock") && oneMove.equals("Scissors"))
                || (twoMove.equals("Scissors") && oneMove.equals("Paper"))
                || (twoMove.equals("Paper") && oneMove.equals("Rock"))) {
            twoWins++;
            roundWinner = "Player Two";
        } else {
            roundWinner = "Nobody";
        }
    }

    /**
     * Return Rock, Paper or Scissors value based on random number
     * 
     * @return the rock, paper, or scissors values based on the randomly generated numbers
     */
    private String chooseRPS() {
        // TODO: implement this method. Use Math.random() and the values .33 and .66 to
        // make equally likely random choices of "Rock", "Paper", "Scissors".
    	double rand = Math.random();
    	if(rand <= 0.33) {
    		return ("Rock");
    	}
    	else if (rand <= 0.66) {
    		return("Paper");
    	}
    	else{
    		return("Scissors");
    	}
    }

    /**
     * Prints results as game progresses
     */
    private void showGame() {
        System.out.println(oneMove + " vs. " + twoMove + ": " + roundWinner + " wins.");
    }

    /**
     * determines the winner of the match
     */
    private void judgeAndReport() {
        if (oneWins > twoWins) {
            winner = "Player One";
        } else if (oneWins < twoWins) {
            winner = "Player Two";
        } else {
            winner = "Nobody";
        }

        System.out.println();
        System.out.println("Player One rounds won: " + oneWins);
        System.out.println("Player Two rounds won: " + twoWins);
        System.out.println("Winner?: " + winner);
    }

}
