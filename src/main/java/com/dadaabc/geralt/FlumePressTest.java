package com.dadaabc.geralt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlumePressTest {
    public static Logger logger = LoggerFactory.getLogger(FlumePressTest.class);

    public static void main(String[] a) {
        for (int j = 1; j <= 10; j++) {
            final int k = j;
            Thread t = new Thread(() -> {
                int i = 0;
                for (; ; ) {
                    logger.info("number{} online {}", k, i++);
                }
            });
            t.setName("thread" + j++);
            t.start();
        }
    }
}
