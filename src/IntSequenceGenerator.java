import java.util.*;

public class IntSequenceGenerator {
    Random rand = new Random(System.currentTimeMillis());

    public int[] generateRandomIntSequence(int numOfInts, int startInclusive, int endInclusive){
        int[] sequence = new int[(endInclusive-startInclusive) + 1];
        for(int i = 0; i < sequence.length; i++){
            int randNum = rand.nextInt(endInclusive);

            // Keep looking for a random int that falls in the range startInclusive to endInclusive because Random doesn't let you
            // define a double-ended range. Only a range from 0 to some endInclusive
            while (randNum < startInclusive){
                randNum = rand.nextInt(endInclusive);
            }
            sequence[i] = randNum;
        }

        return sequence;
    }
}
