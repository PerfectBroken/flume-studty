package com.dadaabc.geralt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FlumeFileSourceTest {
    /*
      logback.xml 启用 “file” appender。将日志写入 /data0/logs/flume-test/flume-test-java.log
      flume 配置为： （将source文件的日志写到sink文件）

                # example.conf: A single-node Flume configuration
                # Name the components on this agent
                a1.sources = r1
                a1.sinks = k1
                a1.channels = c1

                # Describe/configure the source
                a1.sources.r1.type = TAILDIR
                a1.sources.r1.positionFile = /data0/software/apache-flume-1.9.0-bin/taildir_position.json
                a1.sources.r1.filegroups = f1
                a1.sources.r1.filegroups.f1 = /data0/logs/flume-test/flume-test-java.log
                a1.sources.r1.headers.f1.headerKey1 = value1
                a1.sources.r1.fileHeader = true
                a1.sources.ri.maxBatchCount = 1000

                # Describe the sink
                a1.sinks.k1.type = file_roll
                a1.sinks.k1.channel = c1
                a1.sinks.k1.sink.directory = /data0/logs/flume-test/

                # Use a channel which buffers events in memory
                a1.channels.c1.type = memory
                a1.channels.c1.capacity = 1000
                a1.channels.c1.transactionCapacity = 100

                # Bind the source and sink to the channel
                a1.sources.r1.channels = c1
                a1.sinks.k1.channel = c1

       运行开启flume agent
       cd /data0/software/apache-flume-1.9.0-bin
       bin/flume-ng agent --conf conf --conf-file example2.conf --name a1 -Dflume.root.logger=INFO,console


       运行查看文件写入情况
       生成的日志文件名称为 1552550184148-1 是否可以指定？
     */
    public static Logger logger = LoggerFactory.getLogger(FlumeFileSourceTest.class);

    public static void main(String[] a) throws Exception {
//        getTime();
        test();
    }

    public static void getTime() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            logger.info("online " + i);
        }
        System.out.println("logback共耗时" + (System.currentTimeMillis() - begin));
        //10000 - logback共耗时121
    }

    public static void test() throws Exception {
        for (int i = 0; i < 100000; i++) {
            logger.info("online " + i);
            Thread.sleep(3000);
        }
    }
}
