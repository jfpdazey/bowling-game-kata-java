package bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> frames = new ArrayList<>();

    public BowlingGame() {
        frames.add(new Frame());
    }

    public void roll(int pins) {
        Frame currentFrame = frames.get(frames.size() - 1);
        if (currentFrame.isFull()) {
            currentFrame = new Frame();
            frames.add(currentFrame);
        }
        currentFrame.addRoll(pins);
    }

    public int score() {
        int total = 0;

        List<Integer> rolls = new ArrayList<>();
        frames.stream().forEach(it -> rolls.addAll(it.rolls));
        for (int x = 0; x < frames.size(); x++) {
            total += frames.get(x).score(x > 0 && frames.get(x - 1).isSpare());
        }

        return total;
    }
}

class Roll {
    int pinCount = 0;
    boolean isStrike = false;
    boolean isSpare = false;

    public Roll(int pinCount, boolean isSpare) {
        this.pinCount = pinCount;
        this.isSpare = isSpare;

    }
}

class Frame {
    // TODO: 4/26/17 Refactor this to a two-element list... 
    private boolean hasFirstRoll = false;
    private boolean hasSecondRoll = false;
    private int firstRoll = 0;
    private int secondRoll = 0;

    public List<Integer> rolls = new ArrayList<>();
    public void addRoll(int pins) {
        rolls.add(pins);
        if (!hasFirstRoll) {
            firstRoll = pins;
            hasFirstRoll = true;
        } else {
            secondRoll = pins;
            hasSecondRoll = true;
        }
    }

    public boolean isFull() {
        return isStrike() || hasSecondRoll;
    }

    public boolean isStrike() {
        return firstRoll == 10;
    }

    public boolean isSpare() {
        return firstRoll + secondRoll == 10;
    }

    public int score(boolean precededBySpare) {
        return firstRoll + secondRoll + (precededBySpare ? firstRoll : 0);
    }
}