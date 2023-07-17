package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> expected = new AListNoResizing<>();
        BuggyAList<Integer> test = new BuggyAList<>();
        expected.addLast(3);
        test.addLast(3);
        expected.addLast(4);
        test.addLast(4);
        expected.addLast(5);
        test.addLast(5);

        assertEquals(expected.size(), test.size());
        assertEquals(expected.removeLast(), test.removeLast());
        assertEquals(expected.removeLast(), test.removeLast());
        assertEquals(expected.removeLast(), test.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> BL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                BL.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
            } else if (operationNumber == 2 && L.size() > 0) {
                // getLast and RemoveLast
                assertEquals(L.removeLast(), BL.removeLast());
            }
        }
    }
}
