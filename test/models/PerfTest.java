package models;

import org.junit.*;
import play.Logger;

/**
 * Some performance tests
 * @author Sryl <cyril.lacote@gmail.com>
 */
@Ignore
public class PerfTest extends BaseDataUnitTest {

    private static final int NB = 10000;

    private void bench(String testName, Runnable task) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < NB; i++) {
            task.run();
        }
        long end = System.currentTimeMillis();
        Logger.info("%s : %dms", testName, end-start);
    }
    
    /**
     * Total : 830ms
     */
    @Test
    public void findPlay() {
        bench("findPlay", new Runnable() {
            public void run() {
                Member bob = Member.find("byLogin", "bob").first();
            }
        });
    }

    /**
     * Total : 730ms
     */
    @Test
    public void findNamedQuery() {
        bench("findNamedQuery", new Runnable() {
            public void run() {
                Member bob = Member.findByLogin("bob");
            }
        });
    }
}
