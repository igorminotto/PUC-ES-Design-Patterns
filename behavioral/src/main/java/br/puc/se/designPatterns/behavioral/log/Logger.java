package br.puc.se.designPatterns.behavioral.log;

public interface Logger {

	void setLogLevel(LogLevel logLevel);
	
	void log(LogLevel messageLevel, String message);
	
	void addListener(LogListener listener);
	
}
