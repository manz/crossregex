package main;

import crossregex.Solver;

import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * User: emmanuel
 * Date: 08/03/13
 * Time: 14:18
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Solver solver = new Solver();
        String solution = solver.solve();

        prettyPrintSolutions(solution, System.out);
        System.out.println("-------");
        prettyPrintReverseSolutions(solution, System.out);
    }

    private static void prettyPrintSolutions(String solution, PrintStream printStream) {
        _prettyPrintSolutions(solution, false, printStream);
    }

    private static void prettyPrintReverseSolutions(String solution, PrintStream printStream) {
        _prettyPrintSolutions(solution, true, printStream);
    }

    private static void _prettyPrintSolutions(String solution, boolean reverseOrder, PrintStream printStream) {
        for (int k = 0; k < 6; k++) {
            for (int j = 0; j < 6; j++) {
                int index = (k + j) % 6;

                if (reverseOrder) {
                    index = 5 - index;
                }
                printStream.print(solution.charAt(index));
            }
            printStream.println("");
        }

    }
}
