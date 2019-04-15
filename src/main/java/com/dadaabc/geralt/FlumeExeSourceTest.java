package com.dadaabc.geralt;

public class FlumeExeSourceTest {
    /*
    断点续传？
    a1.sources.r1.shell = /bin/bash -c
    a1.sources.r1.command = tail -n +$(tail -n1 /home/hadoop/flume_read/m) -F /home/hadoop/student.txt | awk 'ARGIND==1{i=$0;next}{i++;if($0~/^tail/){i=0};print $0;print i >> "/home/hadoop/flume_read/m";fflush("")}' /home/hadoop/flume_read/m -


          #-----------------rpc-client-------------------

          # Name the components on this agent
          a1.sources = r1
          a1.sinks = k1
          a1.channels = c1

          # Describe/configure the source
          a1.sources.r1.type = exec
          a1.sources.r1.command = tail -F /data0/logs/flume-test/flume-test-java.log

          # Describe the sink
          a1.sinks.k1.type = avro
          a1.sinks.k1.channel = c1
          a1.sinks.k1.hostname = 10.10.10.10
          a1.sinks.k1.port = 4141

          # Use a channel which buffers events in memory
          a1.channels.c1.type = memory
          a1.channels.c1.capacity = 1000
          a1.channels.c1.transactionCapacity = 100

          # Bind the source and sink to the channel
          a1.sources.r1.channels = c1
          a1.sinks.k1.channel = c1
     */
    public static void main(String[] a) {

    }
}
