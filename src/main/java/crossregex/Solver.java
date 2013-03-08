package crossregex;

import choco.Choco;
import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.constraints.automaton.DFA;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.solver.variables.integer.IntDomainVar;

import static choco.Choco.eq;
import static choco.Choco.regular;

/**
 * Created with IntelliJ IDEA.
 * User: emmanuel
 * Date: 08/03/13
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */
public class Solver {
    public String solve() {
        IntegerVariable[] v = new IntegerVariable[38];

        for (int i = 0; i < v.length; i++) {
            v[i] = new IntegerVariable("v_" + i, 1, 26);
        }

        //123456789<10><11><12><13><14><15><16><17><18><19><20><21><22><23><24><25><26>
        Constraint c_1 = regular(new DFA("[1-<26>]*9[1-<26>]*", 4), new IntegerVariable[]{v[28], v[27], v[26], v[25]});
        //28 27 26 25
        //123456789<10><11><12><14><15><16><17><18><19><21><22><23><24><25><26>

        Constraint c_2 = Choco.regular(new DFA("(<13><20>|<20>)*[123456789<10><11><12><14><15><16><17><18><19><21><22><23><24><25><26>]*", 5), new IntegerVariable[]{v[29], v[13], v[12], v[11], v[24]});
        //29 13 12 11 24

        Constraint c_3 = Choco.regular(new DFA("(9<15>|<20>1|<13><21>|34)*", 6), new IntegerVariable[]{v[30], v[14], v[4], v[3], v[10], v[24]});
        //30 14 4  3  10 24

        Constraint c_4 = Choco.regular(new DFA("<13>*(<15><20>9)*<18>*", 7), new IntegerVariable[]{v[31], v[15], v[5], v[1], v[2], v[9], v[22]});
        //31 15 5  1  2  9  22

        Constraint c_5 = Choco.regular(new DFA("[1-<26>][1-<26>][1<13>]*[1-<26>][1-<26>]", 6), new IntegerVariable[]{v[32], v[16], v[6], v[7], v[8], v[21]});
        //32 16 6  7  8  21

        Constraint c_6 = Choco.regular(new DFA("9*<15>*", 5), new IntegerVariable[]{v[33], v[17], v[18], v[19], v[20]});
        //  33 17 18 19 20

        Constraint c_7 = Choco.regular(new DFA("[1-<26>]*", 4), new IntegerVariable[]{v[34], v[35], v[36], v[37]});
        //34 35 36 37


        //12356789<10><11><12><13><14><16><17><18><19><21><22><23><24><25><26>

        Constraint c_8 = Choco.regular(new DFA("(<20><15>|[12356789<10><11><12><13><14><16><17><18><19><21><22><23><24><25><26>])*", 4), new IntegerVariable[]{v[22], v[21], v[20], v[37]});
        //    22 21 20 37
        Constraint c_9 = Choco.regular(new DFA("[1-<26>]*", 5), new IntegerVariable[]{v[23], v[9], v[8], v[19], v[36]});
        //              23  9  8 19 36
        Constraint c_9b = Choco.regular(new DFA("[1-<26>]*1<15><18>[1-<26>]*", 6), new IntegerVariable[]{v[24], v[10], v[2], v[7], v[19], v[35]});
        //         24 10  2  7 19 35
        //1245678<10><11><12><13><14><15><16><17><18><19><20><21><22><23><24><25><26>

        Constraint c_10 = Choco.regular(new DFA("[1245678<10><11><12><13><14><15><16><17><18><19><20><21><22><23><24><25><26>]*9*", 7), new IntegerVariable[]{v[25], v[11], v[3], v[1], v[6], v[17], v[34]});
        // 25 11  3  1  6 17 34
        Constraint c_11 = Choco.regular(new DFA("[<20>9]*", 6), new IntegerVariable[]{v[26], v[12], v[4], v[5], v[16], v[33]});
        //  26 12  4  5 16 33
        Constraint c_12 = Choco.regular(new DFA("[1-<26>]?(<20><21>)*[1-<26>]?", 5), new IntegerVariable[]{v[27], v[13], v[14], v[15], v[32]});
        //     27 13 14 15 32
        Constraint c_13 = Choco.regular(new DFA("[1-<26>]*<13>[1-<26>]<13>[1-<26>]*", 4), new IntegerVariable[]{v[28], v[29], v[30], v[31]});
        //     28 29 30 31

        Constraint c_14 = Choco.regular(new DFA("[1-<26>]*", 4), new IntegerVariable[]{v[34], v[33], v[32], v[31]});
        // 34 33 32 31
        Constraint c_15 = Choco.regular(new DFA("[1-<26>]*9[1-<26>]*", 5), new IntegerVariable[]{v[35], v[17], v[16], v[15], v[30]});
        // 35 17 16 15 30
        Constraint c_16 = Choco.regular(new DFA("(9|<21><20>|4<15><13>)*", 6), new IntegerVariable[]{v[36], v[18], v[6], v[5], v[14], v[29]});
        //   36 18  6  5 14 29
        Constraint c_17 = Choco.regular(new DFA("(1<15>)*<20><20>[1-<26>]*", 7), new IntegerVariable[]{v[37], v[19], v[7], v[1], v[4], v[13], v[28]});
        // 37 19  7  1  4 13 28
        Constraint c_18 = Choco.regular(new DFA("[1-<26>]*<15>[1-<26>]*<15>[1-<26>]*", 6), new IntegerVariable[]{v[20], v[8], v[2], v[3], v[12], v[27]});
        //     20  8  2  3 12 27
        Constraint c_19 = Choco.regular(new DFA("[<20>93]*", 5), new IntegerVariable[]{v[21], v[9], v[10], v[11], v[26]});
        //  21  9 10 11 26
        Constraint c_20 = Choco.regular(new DFA("[1-<26>]*444[1-<26>]*", 4), new IntegerVariable[]{v[22], v[23], v[24], v[25]});
        // 22 23 24 25


        CPModel model = new CPModel();


        model.addVariables(v);
        model.removeVariable(v[0]);
        model.addConstraints(c_1, c_2, c_3, c_4, c_5, c_6, c_7, c_8, c_9, c_9b, c_10, c_11, c_12, c_13, c_14, c_15, c_16, c_17, c_18, c_19, c_20);

        model.addConstraint(eq(v[32], v[8]));
        model.addConstraint(eq(v[16], v[21]));
        CPSolver solver = new CPSolver();

        solver.read(model);
        boolean hasSolution = solver.solveAll();


        String alpha = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        IntDomainVar[] domain = {
                solver.getVar(v[2]),
                solver.getVar(v[3]),
                solver.getVar(v[4]),
                solver.getVar(v[5]),
                solver.getVar(v[6]),
                solver.getVar(v[7])
        };

        String solution = null;

        if (hasSolution) {
           solution = "";
           for (int k = 0; k < 6; k++) {
                solution = solution + alpha.charAt(domain[k].getValue());
            }
        }


        return solution;
    }
}
