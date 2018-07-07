package br.puc.se.designPatterns.behavioral.log;

public enum LogLevel {

	DEBUG(4), INFO(3), WARNING(2), ERROR(1), FATAL(0);

	private int priority;

	private LogLevel(int priority) {
		this.priority = priority;
	}
	
	public int getPriority() {
		return priority;
	}
	
}
