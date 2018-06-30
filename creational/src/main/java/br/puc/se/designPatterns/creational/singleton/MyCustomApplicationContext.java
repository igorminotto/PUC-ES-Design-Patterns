package br.puc.se.designPatterns.creational.singleton;

public class MyCustomApplicationContext {
	static private MyCustomApplicationContext instance;
	
	static MyCustomApplicationContext getInstance() {
		if(MyCustomApplicationContext.instance == null) {
			MyCustomApplicationContext.instance = new MyCustomApplicationContext();
		}
		return MyCustomApplicationContext.instance;
	}
	
	private MyCustomApplicationContext() {
		
	}
}
