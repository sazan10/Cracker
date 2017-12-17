package com.threads;

public class Thread_fact {
	private String[] username = { "roshan", "sita", "ram", "prajwal" };

	public void thread_factory() {
		for (String s : username) {
			for (int i = 0; i < 100; i++) {
				Thread_creator thread = new Thread_creator(s, i);
				thread.start();
				if (Thread_creator.getResult()) {
					System.out.println(Thread_creator.getResult());
					break;
				}
			}
		}
	}
}
