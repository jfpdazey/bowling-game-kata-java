package bowlinggame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BowlingTest {
    private BowlingGame subject;
    @Before
    public void setUp() throws Exception {
        subject = new BowlingGame();
    }

    @Test
    public void aGameStartsWithAScoreOfZero() {
        assertEquals(0, subject.score());
    }

    @Test
    public void rollAddsPinsToScore() {
        subject.roll(4);

        assertEquals(4, subject.score());
    }

    @Test
    public void addsPinsFromTwoRollsToScore()  {
        subject.roll(4);
        subject.roll(1);

        assertEquals(5, subject.score());
    }

    @Test
    public void spareDoublesNextRollWhenInAValidFrame() {
        rollASpare();
        subject.roll(5);
        subject.roll(1);

        assertEquals(21, subject.score());
    }

    @Test
    public void spareDoesNotDoubleNextRollWhenInAnInvalidFrame() {
        subject.roll(4);
        subject.roll(6);
        subject.roll(4);
        subject.roll(1);

        assertEquals(19, subject.score());
    }

    private void rollASpare() {
        subject.roll(4);
        subject.roll(6);
    }
}
