package com.study.swift.server;

import static java.util.concurrent.Executors.newCachedThreadPool;
import static java.util.concurrent.Executors.newFixedThreadPool;

import java.util.concurrent.ExecutorService;

import com.facebook.nifty.core.NettyServerConfig;
import com.facebook.nifty.core.ThriftServerDef;
import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftEventHandler;
import com.facebook.swift.service.ThriftServer;
import com.facebook.swift.service.ThriftServiceProcessor;
import com.google.common.collect.ImmutableList;

/**
 * Created by luoyong on 16-9-12.
 */
public class DemoThriftServer {
	public static void main(String[] args) {
		ServerCreator serverCreator = new ServerCreator().invoke();
		ThriftServer server = serverCreator.getServer();

		server.start();
		System.out.println("服务已启动!");

		// serverCreator.stop();
		// serverCreator.checkExecutorsTerminated();
	}

	static class ServerCreator {
		private ExecutorService taskWorkerExecutor;
		private ThriftServer server;
		private ExecutorService bossExecutor;
		private ExecutorService ioWorkerExecutor;

		public ThriftServer getServer() {
			return server;
		}

		public ServerCreator invoke() {
			ThriftServiceProcessor processor = new ThriftServiceProcessor(new ThriftCodecManager(),
					ImmutableList.<ThriftEventHandler>of(), new CalculatorImpl());

			taskWorkerExecutor = newFixedThreadPool(1);

			ThriftServerDef serverDef = ThriftServerDef.newBuilder().listen(12345).withProcessor(processor)
					.using(taskWorkerExecutor).build();

			bossExecutor = newCachedThreadPool();
			ioWorkerExecutor = newCachedThreadPool();

			NettyServerConfig serverConfig = NettyServerConfig.newBuilder().setBossThreadExecutor(bossExecutor)
					.setWorkerThreadExecutor(ioWorkerExecutor).build();

			server = new ThriftServer(serverConfig, serverDef);
			return this;
		}

		public void stop() {
			server.close();
		}
	}
}
