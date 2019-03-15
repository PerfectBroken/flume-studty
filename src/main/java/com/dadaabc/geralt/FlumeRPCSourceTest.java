package com.dadaabc.geralt;

import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;
import org.apache.flume.Event;

import java.nio.charset.Charset;

public class FlumeRPCSourceTest {
    /*
     使用socket,发送apache的Avro格式数据到flume


     */
    public static void main(String[] args) {
        RpcClient client = null;
        client = RpcClientFactory.getDefaultInstance("127.0.0.1", 4141);
        try {
            long begin = System.currentTimeMillis();
            for(int i = 0; i < 100000; i++) {
                Event event = EventBuilder.withBody("online" + i, Charset.forName("UTF-8"));
                client.append(event);
            }
            System.out.println("rpc共耗时" + (System.currentTimeMillis() - begin));
            //10000  - rpc共耗时1481
            //100000 -
        } catch (EventDeliveryException e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }
}