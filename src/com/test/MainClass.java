/**
 * 
 */
package com.test;

/**
 * @author Shrikant
 *
 */
public class MainClass {

	public synchronized void m1() {
		System.out.println("before method m1");
		m2();
		System.out.println("after method m1");
	}

	public synchronized void m2() {
		System.out.println( "method m2");
	}

	public static void main(String[] args) throws InterruptedException {
		MainClass t = new MainClass();
		Thread t1 = new Thread() {
			public void run() {
				t.m1();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				t.m2();
			}
		};

		t1.start();
		t2.start();
		System.out.println(t2.getState());
	}
}
