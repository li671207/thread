package com.lihl.thread;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;

public class CDownload implements Callable<Boolean> {
	private String url;
	private String name;

	public CDownload(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public Boolean call() throws Exception{
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
			System.out.println(name);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CDownload td1 = new CDownload("http://img95.699pic.com/photo/50043/7258.jpg_wh860.jpg", "image1.jpg");
		CDownload td2 = new CDownload("http://img95.699pic.com/photo/50111/2423.jpg_wh860.jpg", "image2.jpg");
		CDownload td3 = new CDownload("http://seopic.699pic.com/photo/50070/6290.jpg_wh1200.jpg", "image3.jpg");
		
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		
		Future<Boolean> future1 = threadPool.submit(td1);
		Future<Boolean> future2 = threadPool.submit(td2);
		Future<Boolean> future3 = threadPool.submit(td3);
		
		System.out.println(future1.get());
		
		threadPool.shutdown();
	}
}
