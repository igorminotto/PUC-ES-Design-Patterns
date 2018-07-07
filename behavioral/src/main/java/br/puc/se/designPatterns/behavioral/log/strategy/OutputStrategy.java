package br.puc.se.designPatterns.behavioral.log.strategy;

import br.puc.se.designPatterns.behavioral.log.LogLevel;

public interface OutputStrategy {
	String formatMessage(LogLevel messageLevel, String message);
	void doLog(String formatedMessage);
}
