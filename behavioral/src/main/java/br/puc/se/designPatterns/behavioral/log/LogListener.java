package br.puc.se.designPatterns.behavioral.log;

import java.util.LinkedList;
import java.util.List;

public class LogListener {

	private List<String> logs = new LinkedList<>();
	
	public  void onLog(String formatedMessage) {
		this.logs.add(formatedMessage);
	}
	
	public List<String> getLogs() {
		return logs;
	}

}
