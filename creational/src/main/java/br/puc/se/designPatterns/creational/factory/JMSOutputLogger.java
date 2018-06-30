package br.puc.se.designPatterns.creational.factory;

public class JMSOutputLogger extends OutputLogger {

	@Override
	protected String formatMessage(String logMessage) {
		return logMessage;
	}

}
