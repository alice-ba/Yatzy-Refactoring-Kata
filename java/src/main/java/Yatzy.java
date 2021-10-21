import java.util.Arrays;

public class Yatzy {
    private int[] dice;

    public Yatzy(int[] providedDice) {
        if (providedDice.length != 5) {
            throw new IllegalArgumentException("There should be exactly 5 dice");
        }
        if (Arrays.stream(providedDice).anyMatch(die -> die > 6 || die < 1)) {
            throw new IllegalArgumentException("The dice values are expected to be between 1 and 6");
        }
        this.dice = providedDice;
    }

    public int chance() {
        int total = 0;
        for (int die : this.dice) {
            total += die;
        }
        return total;
    }

    public int yatzy() {
        int[] counts = this.computeCountArray();
        for (int c : counts) {
            if (c == counts.length - 1) {
                return 50;
            }
        }
        return 0;
    }

    public int ones(){
        return this.sumOfDice(1);
    }
    public int twos(){
        return this.sumOfDice(2);
    }
    public int threes(){
        return this.sumOfDice(3);
    }
    public int fours(){
        return this.sumOfDice(4);
    }
    public int fives(){
        return this.sumOfDice(5);
    }
    public int sixes(){
        return this.sumOfDice(6);
    }

    public int onePair() {
        return this.computeXOfAKind(2);
    }

    public int twoPair() {
        int[] counts = this.computeCountArray();
        int numberOfPair = 0;
        int score = 0;
        for (int i = this.dice.length - 1 ; i >= 0; i--) {
            if (counts[i] >= 2) {
                numberOfPair++;
                score += (i + 1);
            }
        }
        if (numberOfPair == 2) {
            return score * 2;
        }
        return 0;
    }

    public int fourOfAKind() {
        return this.computeXOfAKind(4);
    }

    public int threeOfAKind() {
        return this.computeXOfAKind(3);
    }

    public int smallStraight() {
        int[] counts = this.computeCountArray();
        boolean isSmallStraight = Arrays.stream(Arrays.copyOfRange(counts,0,4)).allMatch(count -> count == 1);

        if (isSmallStraight){
            return 15;
        }
        return 0;
    }

    public int largeStraight() {
        int[] counts = this.computeCountArray();
        boolean isLargeStraight = Arrays.stream(Arrays.copyOfRange(counts,1,5)).allMatch(count -> count == 1);

        if (isLargeStraight) {
            return 20;
        }
        return 0;
    }

    public int fullHouse() {
        int[] counts = this.computeCountArray();
        int pairScore = computeStrictXSome(2, counts);
        int threeScore = computeStrictXSome(3, counts);
        if (pairScore > 0 && threeScore > 0) {
            return pairScore + threeScore;
        }
        return 0;
    }

    private int[] computeCountArray() {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        return counts;
    }

    private int sumOfDice(int countedNumber) {
        return Arrays.stream(this.dice).filter(die -> die == countedNumber).sum();
    }

    private int computeXOfAKind(int expectedNumberOfElement) {
        int[] counts = this.computeCountArray();
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] >= expectedNumberOfElement) {
                return (i + 1) * expectedNumberOfElement;
            }
        }
        return 0;
    }

    private int computeStrictXSome(int expectedNumberOfElement, int[] counts) {
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] == expectedNumberOfElement) {
                return (i + 1) * expectedNumberOfElement;
            }
        }
        return 0;
    }
}



