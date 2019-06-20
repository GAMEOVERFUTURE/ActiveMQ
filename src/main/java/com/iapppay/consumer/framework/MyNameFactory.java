package com.iapppay.consumer.framework;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @className: MyNameFactory
 * @classDescription:
 * @author lishiqiang
 * @create_date: 2019年5月7日 下午2:35:05
 * @update_date:
 */
public class MyNameFactory implements ThreadFactory {

	private static AtomicInteger threadNumber = new AtomicInteger(1);
	private final String namePrefix;

	/**
	 * Constructor accepting the prefix of the threads that will be created by this
	 * {@link ThreadFactory}
	 * 
	 * @param namePrefix
	 *            Prefix for names of threads
	 */
	public MyNameFactory(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	/**
	 * Returns a new thread using a name as specified by this factory {@inheritDoc}
	 */
	public Thread newThread(Runnable runnable) {
		return new Thread(runnable, namePrefix + " thread-" + threadNumber.getAndIncrement());
	}

}
