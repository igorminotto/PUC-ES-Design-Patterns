package br.puc.se.designPatterns.behavioral.log.strategy;

import java.util.HashSet;
import java.util.Set;

import br.puc.se.designPatterns.behavioral.log.LogLevel;
import br.puc.se.designPatterns.behavioral.log.LogListener;
import br.puc.se.designPatterns.behavioral.log.Logger;

public class ConcreteLogger implements Logger {
	protected LogLevel level = LogLevel.INFO;
	
	protected Set<LogListener> listeners = new HashSet<>();
	
	protected OutputStrategy output;
	
	public ConcreteLogger(OutputStrategy output) {
		super();
		this.output = output;
	}

	public OutputStrategy getOutput() {
		return output;
	}
	
	@Override
	public void setLogLevel(LogLevel logLevel) {
		this.level = logLevel;
	}
	
	@Override
	public void log(LogLevel messageLevel, String message) {
		if (messageLevel.getPriority() <= level.getPriority()) {
			String formatedMessage = output.formatMessage(messageLevel, message);
			output.doLog(formatedMessage);
			for (LogListener listener : this.listeners) {
				listener.onLog(formatedMessage);
			}
		}
	}

	@Override
	public void addListener(LogListener listener) {
		this.listeners.add(listener);
	}

}
