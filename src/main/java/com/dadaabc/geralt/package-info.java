package com.dadaabc.geralt;
/*
  #-----------------rpc-client-------------------

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



  #-----------------rpc-server-------------------

  # Name the components on this agent
  a1.sources = r1
  a1.sinks = k1
  a1.channels = c1

  # Describe/configure the source
  a1.sources.r1.type = netcat
  a1.sources.r1.bind = 0.0.0.0
  a1.sources.r1.port = 4141

  # Describe the sink
  a1.sinks.k1.type = file_roll
  a1.sinks.k1.channel = c1
  a1.sinks.k1.sink.directory = /data0/logs/flume-test/
  a1.sinks.k1.sink.rollInterval=1000

  # Use a channel which buffers events in memory
  a1.channels.c1.type = memory
  a1.channels.c1.capacity = 1000
  a1.channels.c1.transactionCapacity = 100

  # Bind the source and sink to the channel
  a1.sources.r1.channels = c1
  a1.sinks.k1.channel = c1


  double flume test
  测试一：当客户端崩溃了,重启客户端后，客户端会从json文件中读取到上次同步的位置(test未知是否收到ack才会更新？)
  when the client flume crash，it will read the json file(sink:positionFile) to get the last updated position;


  测试二：客户端重连机制：当服务端崩溃了，客户端如何重连？
  when the server flume crash,how my client reconnect?
  强关服务器后，客户端走的tcp 重发机制，快速三次重试后开始指数退避。尝试总共9次后，若还没收到ack，则断开连接，发SYN包重连。


  测试三：当服务端不给客户端回复ack的话，客户端重新建连后重复发送的消息服务端是否会被重复消费？
  步骤：
  1.建立好连接，开始同步数据
  2.服务端使用iptables屏蔽ack。此时客户端开始重试发送。
  sudo iptables -I OUTPUT -ptcp --dport 4141 --tcp-flags ACK ACK -j DROP
  sudo iptables -I OUTPUT -ptcp --dport 4141 --tcp-flags ACK,PSH ACK -j DROP
  3.服务端重启服务
  4.去掉iptables,使服务重连，客户端重新发送数据后，查看服务端是否生成相同的数据。
  服务端会存储两条相同的数据！

  ps:若服务端不重启呢？ 也是同样的问题。




 */