package br.puc.se.designPatterns.behavioral.log.templatemethod;

import java.util.HashSet;
import java.util.Set;

import br.puc.se.designPatterns.behavioral.log.LogLevel;
import br.puc.se.designPatterns.behavioral.log.LogListener;
import br.puc.se.designPatterns.behavioral.log.Logger;

public abstract class AbstractLogger implements Logger {

	protected LogLevel level = LogLevel.INFO;
	
	protected Set<LogListener> listeners = new HashSet<>();
	
	protected abstract String formatMessage(LogLevel messageLevel, String message);
	protected abstract void doLog(String formatedMessage);
	
	@Override
	public void setLogLevel(LogLevel logLevel) {
		this.level = logLevel;
	}
	
	@Override
	public void log(LogLevel messageLevel, String message) {
		if (messageLevel.getPriority() <= level.getPriority()) {
			String formatedMessage = this.formatMessage(messageLevel, message);
			this.doLog(formatedMessage);
		}
	}

	@Override
	public void addListener(LogListener listener) {
		this.listeners.add(listener);
	}

}
