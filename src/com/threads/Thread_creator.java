package com.threads;

public class Thread_creator extends Thread {
	private int k;
	private String user;
	public static boolean result1 = false;
	private Checker check = new Checker();

	public static boolean getResult() {
		return result1;
	}

	Thread_creator(String user_, int i) {
		user = user_;
		k = i;
	}

	public void run() {

		if (!result1)
			check.checker(user, "9841", k);
		if (!result1)
			check.checker(user, "9848", k);
		if (!result1)
			check.checker(user, "9849", k);

	}

}
