package br.puc.se.designPatterns.behavioral.log.strategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import br.puc.se.designPatterns.behavioral.log.LogLevel;
import br.puc.se.designPatterns.behavioral.log.LogListener;
import br.puc.se.designPatterns.behavioral.log.Logger;

public class HttpPostLogger implements Logger {

	private LogLevel level = LogLevel.INFO;
	
	private Set<LogListener> listeners = new HashSet<>();
	
	private String uri = "http://localhost:8080";
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public String getUri() {
		return uri;
	}
	
	@Override
	public void setLogLevel(LogLevel logLevel) {
		this.level= logLevel;
	}

	@Override
	public void log(LogLevel messageLevel, String message) {
		if (messageLevel.getPriority() <= level.getPriority()) {
			String formatedMessage = this.formatMessage(messageLevel, message);
			this.doLog(formatedMessage);
		}
	}
	
	private String formatMessage(LogLevel messageLevel, String message) {
		return String.format("[Logger: %s on %s]:%s:%s: %s", "HttpPostLogger", this.uri, new Date(), messageLevel, message);
	}

	private void doLog(String formatedMessage) {
		// mocking the http post over internet and notify the listeners
		for (LogListener listener : this.listeners) {
			listener.onLog(formatedMessage);
		}
	}

	@Override
	public void addListener(LogListener listener) {
		this.listeners.add(listener);
	}

}

