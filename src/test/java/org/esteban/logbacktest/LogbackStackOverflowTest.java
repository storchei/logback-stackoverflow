package org.esteban.logbacktest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackStackOverflowTest {

    private final Logger LOGGER = LoggerFactory.getLogger(LogbackStackOverflowTest.class);

    @Test(expected = StackOverflowError.class)
    public void log_givenExceptionInfiniteLoop_throwException() {
        NullPointerException e1 = new NullPointerException("NPE");
        IllegalArgumentException e2 = new IllegalArgumentException("IAE");
        e2.addSuppressed(e1);
        e1.addSuppressed(e2);

        LOGGER.error("Logging exception", e1);
    }
}
