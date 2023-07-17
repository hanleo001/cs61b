package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        SLList<Integer> totest = new SLList<>();
        AList<Integer> nList = new AList<>();
        AList<Double> timeList = new AList<>();
        AList<Integer> opList = new AList<>();
        for (int i = 1; i <= 128000; i++){
            totest.addLast(0);
            if (i == 1000 || i == 2000 || i == 4000 || i == 8000 || i == 16000 || i == 32000 || i == 64000 || i == 128000 || i == 1280000000 ){
                nList.addLast(i);
                Stopwatch main = new Stopwatch();
                for (int j = 0; j < 10000; j++)
                    totest.getLast();
                timeList.addLast(main.elapsedTime());
                opList.addLast(10000);
            }

        }
        printTimingTable(nList, timeList, opList);
    }

}
