package br.puc.se.designPatterns.behavioral.log.templatemethod;

import java.util.Date;

import br.puc.se.designPatterns.behavioral.log.LogLevel;
import br.puc.se.designPatterns.behavioral.log.LogListener;

public class ConsoleLogger extends AbstractLogger {
	
	@Override
	protected String formatMessage(LogLevel messageLevel, String message) {
		return String.format("[Logger: %s] %s:%s: %s", "ConsoleLogger", new Date(), messageLevel, message);
	}

	@Override
	protected void doLog(String formatedMessage) {
		// mock the log for console and send it to listeners
		for (LogListener listener : this.listeners) {
			listener.onLog(formatedMessage);
		}
	}

}
