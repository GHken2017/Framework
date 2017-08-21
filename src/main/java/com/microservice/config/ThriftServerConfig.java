package com.microservice.config;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservice.util.ThriftServiceAnnotation;

@Configuration
public class ThriftServerConfig {

	// 日志对象
	private static Logger logger = LoggerFactory.getLogger(ThriftServerConfig.class);

	// 注册端口
	public String asServicePort;

	@Autowired
	private ApplicationContext applicationContext;

	// 单线程化的线程池
	private ExecutorService executor = Executors.newSingleThreadExecutor();

	@Bean
	public TNonblockingServerSocket tServerTransport() {

		try {

			asServicePort = "10020";
			// 传输通道 - 非阻塞方式
			return new TNonblockingServerSocket(Integer.parseInt(asServicePort));
		} catch (TTransportException e) {
		}
		return null;
	}

	@Bean
	public TServer tServer() {

		TMultiplexedProcessor tMultiplexedProcessor = new TMultiplexedProcessor();

		String[] thriftServices = this.applicationContext.getBeanNamesForAnnotation(ThriftServiceAnnotation.class);

		for (String thriftService : thriftServices) {

			Object serviceBean = this.applicationContext.getBean(thriftService);
			Class<?>[] interfaces = serviceBean.getClass().getInterfaces();
			TProcessor processor = null;

			for (Class<?> clazz : interfaces) {

				String className = clazz.getEnclosingClass().getSimpleName();
				String serviceName = clazz.getEnclosingClass().getName();
				String processorName = serviceName + "$Processor";
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				try {
					Class<?> processorClass = classLoader.loadClass(processorName);
					if (!TProcessor.class.isAssignableFrom(processorClass)) {
						continue;
					}
					Constructor<?> constructor = processorClass.getConstructor(clazz);
					processor = (TProcessor) constructor.newInstance(serviceBean);
				} catch (ClassNotFoundException e) {
					logger.error(e.getMessage());
				} catch (NoSuchMethodException e) {
					logger.error(e.getMessage());
				} catch (IllegalAccessException e) {
					logger.error(e.getMessage());
				} catch (InstantiationException e) {
					logger.error(e.getMessage());
				} catch (InvocationTargetException e) {
					logger.error(e.getMessage());
				}

				String annotationValue = serviceBean.getClass().getAnnotation(ThriftServiceAnnotation.class).value();

				if (annotationValue.isEmpty()) {
					tMultiplexedProcessor.registerProcessor(className, processor);
				} else {
					tMultiplexedProcessor.registerProcessor(annotationValue, processor);
				}
			}
		}

		// 多线程半同步半异步
		TThreadedSelectorServer.Args tArgs = new TThreadedSelectorServer.Args(tServerTransport());
		tArgs.processor(tMultiplexedProcessor);
		tArgs.transportFactory(new TFramedTransport.Factory());
		// 二进制协议
		// tArgs.protocolFactory(new TBinaryProtocol.Factory());
		tArgs.protocolFactory(new TBinaryProtocol.Factory());
		// 使用对象池
		tArgs.processorFactory(new TProcessorFactory(tMultiplexedProcessor));
		// 多线程半同步半异步的服务模型
		TServer server = new TThreadedSelectorServer(tArgs);

		return server;
	}

	@PostConstruct
	public void init() {

		executor.execute(new Runnable() {
			@Override
			public void run() {

				// thrift服务实例化
				TServer tserver = tServer();
				// 启动服务
				tserver.serve();
			}
		});
	}
}
