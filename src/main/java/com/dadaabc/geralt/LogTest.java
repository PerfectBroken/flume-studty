package com.dadaabc.geralt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Random;


public class LogTest {
    private static Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Deprecated
    public static void main(String[] a) throws Exception {
        ArrayList<Integer> arr = new ArrayList<>();
        Random random = new Random();
        int i;
        for (; ; ) {
            i = random.nextInt();
            arr.add(i);
            logger.info("online " + i);
            if (arr.size() > 100) {
                int j = arr.get(random.nextInt(100));
                arr.remove((Integer) j);
                logger.info("offline" + j);
            }
            Thread.sleep(500);
        }
        //报异常: ERROR in ch.qos.logback.core.joran.action.AppenderAction -
        //       Could not create an Appender of type [org.apache.flume.clients.log4jappender.Log4jAppender].
        //       ch.qos.logback.core.util.IncompatibleClassException
        //查看接口发现 ，flume的客户端有支持log4j appender的实现，不支持logback。很尴尬。
    }
}
