package crossregex;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: emmanuel
 * Date: 08/03/13
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
public class SolverTest {
    @Test
    public void testSolve() throws Exception {
        Solver s = new Solver();

        Assert.assertNotNull(s.solve());

    }
}
