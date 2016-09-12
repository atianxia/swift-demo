package com.study.swift.client;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;

import org.apache.thrift.TException;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import com.study.swift.tutorial.Calculator;

/**
 * Created by luoyong on 16-9-12.
 */
public class DemoThriftClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TException {
    	  ThriftClientManager clientManager = new ThriftClientManager();
          Calculator calculator = clientManager.createClient(
                  new FramedClientConnector(new InetSocketAddress("localhost", 12345)),
                  Calculator.class).get();
          System.out.println("" + calculator.add(1,2));
   
          int max = 100000;
          Long start = System.currentTimeMillis();
          for (int i = 0; i < max; i++) {
              calculator.ping();
          }
          Long end = System.currentTimeMillis();
          Long elapse = end - start;
          int perform = Double.valueOf(max / (elapse / 1000d)).intValue();
   
          System.out.print("thrift " + max + " 次RPC调用，耗时：" + elapse + "毫秒，平均" + perform + "次/秒");
   
      }
}
