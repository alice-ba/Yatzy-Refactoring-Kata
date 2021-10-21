import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class YatzyTest {

    @Test
    public void wrongDiceParameters(){
        assertThrows(IllegalArgumentException.class, () -> new Yatzy(new int[] {2,3,4,5}));
        assertThrows(IllegalArgumentException.class, () -> new Yatzy(new int[] {2,3,4,5,6,4}));
        assertThrows(IllegalArgumentException.class, () -> new Yatzy(new int[] {2,3,4,7,4}));
        assertThrows(IllegalArgumentException.class, () -> new Yatzy(new int[] {0,3,4,6,4}));
    }

    @Test
    public void chanceScoresSumOfAllDice() {
        assertEquals(15, new Yatzy(new int[] {2,3,4,5,1}).chance());
        assertEquals(16, new Yatzy(new int[] {3,3,4,5,1}).chance());
    }

    @Test
    public void yatzyScores() {
        assertEquals(50, new Yatzy(new int[] {4,4,4,4,4}).yatzy());
        assertEquals(50, new Yatzy(new int[] {6,6,6,6,6}).yatzy());
        assertEquals(0, new Yatzy(new int[] {6,6,6,6,3}).yatzy());
    }

    @Test
    public void onesTest() {
        assertEquals(1, new Yatzy(new int[] {1,2,3,4,5}).ones());
        assertEquals(2, new Yatzy(new int[] {1,2,1,4,5}).ones());
        assertEquals(0, new Yatzy(new int[] {6,2,2,4,5}).ones());
        assertEquals(4, new Yatzy(new int[] {1,2,1,1,1}).ones());
    }

    @Test
    public void twosTest() {
        assertEquals(4, new Yatzy(new int[] {1,2,3,2,6}).twos());
        assertEquals(10, new Yatzy(new int[] {2,2,2,2,2}).twos());
    }

    @Test
    public void threesTest() {
        assertEquals(6, new Yatzy(new int[] {1,2,3,2,3}).threes());
        assertEquals(12, new Yatzy(new int[] {2,3,3,3,3}).threes());
    }

    @Test
    public void foursTest() {
        assertEquals(12, new Yatzy(new int[] {4,4,4,5,5}).fours());
        assertEquals(8, new Yatzy(new int[] {4,4,5,5,5}).fours());
        assertEquals(4, new Yatzy(new int[] {4,5,5,5,5}).fours());
    }

    @Test
    public void fivesTest() {
        assertEquals(10, new Yatzy(new int[] {4,4,4,5,5}).fives());
        assertEquals(15, new Yatzy(new int[] {4,4,5,5,5}).fives());
        assertEquals(20, new Yatzy(new int[] {4,5,5,5,5}).fives());
    }

    @Test
    public void sixesTest() {
        assertEquals(0, new Yatzy(new int[] {4,4,4,5,5}).sixes());
        assertEquals(6, new Yatzy(new int[] {4,4,6,5,5}).sixes());
        assertEquals(18, new Yatzy(new int[] {6,5,6,6,5}).sixes());
    }

    @Test
    public void onePair() {
        assertEquals(6, new Yatzy(new int[] {3,4,3,5,6}).onePair());
        assertEquals(10, new Yatzy(new int[] {5,3,3,3,5}).onePair());
        assertEquals(12, new Yatzy(new int[] {5,3,6,6,5}).onePair());
    }

    @Test
    public void twoPair() {
        assertEquals(16, new Yatzy(new int[] {3,3,5,4,5}).twoPair());
        assertEquals(16, new Yatzy(new int[] {3,3,5,5,5}).twoPair());
    }

    @Test
    public void threeOfAKind() {
        assertEquals(9, new Yatzy(new int[] {3,3,3,4,5}).threeOfAKind());
        assertEquals(15, new Yatzy(new int[] {5,3,5,4,5}).threeOfAKind());
        assertEquals(9, new Yatzy(new int[] {3,3,3,3,5}).threeOfAKind());
    }

    @Test
    public void fourOfAKind() {
        assertEquals(12, new Yatzy(new int[] {3,3,3,3,5}).fourOfAKind());
        assertEquals(20, new Yatzy(new int[] {5,5,5,4,5}).fourOfAKind());
        assertEquals(12, new Yatzy(new int[] {3,3,3,3,3}).fourOfAKind());
    }

    @Test
    public void smallStraight() {
        assertEquals(15, new Yatzy(new int[] {1,2,3,4,5}).smallStraight());
        assertEquals(15, new Yatzy(new int[] {2,3,4,5,1}).smallStraight());
        assertEquals(0, new Yatzy(new int[] {1,2,2,4,5}).smallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(20, new Yatzy(new int[] {6,2,3,4,5}).largeStraight());
        assertEquals(20, new Yatzy(new int[] {2,3,4,5,6}).largeStraight());
        assertEquals(0, new Yatzy(new int[] {1,2,2,4,5}).largeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(18, new Yatzy(new int[] {6,2,2,2,6}).fullHouse());
        assertEquals(0, new Yatzy(new int[] {2,3,4,5,6}).fullHouse());
    }
}
