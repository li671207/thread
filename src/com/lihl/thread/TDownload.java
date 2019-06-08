package com.lihl.thread;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class TDownload extends Thread {
	private String url;
	private String name;

	public TDownload(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
			System.out.println(name);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TDownload td1 = new TDownload("http://img95.699pic.com/photo/50043/7258.jpg_wh860.jpg", "image1.jpg");
		TDownload td2 = new TDownload("http://img95.699pic.com/photo/50111/2423.jpg_wh860.jpg", "image2.jpg");
		TDownload td3 = new TDownload("http://seopic.699pic.com/photo/50070/6290.jpg_wh1200.jpg", "image3.jpg");
		
		td1.start();
		td2.start();
		td3.start();
	}
}
