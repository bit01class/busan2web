package com.bit.util;

import java.io.IOException;

public class Application {

	public static void main(String[] args) {
		try {
			Process process1 = Runtime.getRuntime().exec("java -jar C:\\Users\\BITCOM\\.m2\\repository\\com\\h2database\\h2\\2.1.214\\h2-2.1.214.jar");
			Process process2 = Runtime.getRuntime().exec("cmd D:\\utils\\apache-maven-3.9.0\\bin\\mvn.cmd jetty:run");
			try {
				Thread.sleep(1000*3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Process process3 = Runtime.getRuntime().exec("explorer http://localhost:8080");
			try {
				Thread.sleep(1000*30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			process1.destroy();
			process2.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
