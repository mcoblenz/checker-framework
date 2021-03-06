package tests;

import org.checkerframework.framework.test.CheckerFrameworkTest;
import org.junit.runners.Parameterized.Parameters;

import java.io.File;

/**
 * JUnit tests for the Nullness checker when running with concurrent semantics
 */
public class NullnessConcurrentTest extends CheckerFrameworkTest {

    public NullnessConcurrentTest(File testFile) {
        super(testFile,
                org.checkerframework.checker.nullness.NullnessChecker.class,
                "nullness",
                "-AconcurrentSemantics",
                "-Anomsgtext");
    }

    @Parameters
    public static String[] getTestDirs() {
        return new String[]{"nullness-concurrent-semantics"};
    }

}
