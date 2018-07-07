package br.puc.se.designPatterns.behavioral.log.strategy;

import java.util.Date;

import br.puc.se.designPatterns.behavioral.log.LogLevel;

public class ConsoleOutput implements OutputStrategy {
	
	public String formatMessage(LogLevel messageLevel, String message) {
		return String.format("[Logger: %s] %s:%s: %s", "ConsoleLogger", new Date(), messageLevel, message);
	}

	public void doLog(String formatedMessage) {
		// mock the log for console and send it to listeners
	}

}
