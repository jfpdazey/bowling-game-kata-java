package bowlinggame;

public class BowlingGame {

    private int totalScore = 0;
    private int previousRollPinCount = 0;
    private boolean sparePending = false;
    private int currentFrame = 1;
    private int currentRollWithinFrame = 1;

    public void roll(int pins)  {

        if (currentRollWithinFrame > 2) {
            currentFrame++;
            currentRollWithinFrame = 1;
        }

        totalScore += pins;
        scoreSpare(pins);
        //if (sparePending) { scoreSpare(pins);}

        sparePending = ((previousRollPinCount + pins) == 10 && currentRollWithinFrame != 1);

        previousRollPinCount = pins;
        currentRollWithinFrame++;
    }

    private void scoreSpare(int pins) {
        if(sparePending) {
            totalScore += pins;
        }
    }

    public int score() {
        return totalScore;
    }
}
