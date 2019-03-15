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


 */