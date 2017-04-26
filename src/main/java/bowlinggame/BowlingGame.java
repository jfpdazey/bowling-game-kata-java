package bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Integer> rolls = new ArrayList<>();

    public void roll(int pins)  {
        rolls.add(pins);
    }

    public int score() {
        int total = 0;

        for (int x = 0 ; x < rolls.size() ; x++) {
            total += rolls.get(x);
            if (x % 2 == 0 && x > 1 && rolls.get(x-1) + rolls.get(x-2) == 10) {
                total += rolls.get(x);
            }
        }

        return total;
    }
}
