package br.puc.se.designPatterns.creational.factory;

public class LogFactory {

	public OutputLogger of(LoggerType httpPost) {
		OutputLogger logger = null;
		if(httpPost.equals(LoggerType.HTTP_POST)) {
			logger = new HTTPOutputLogger();
		} else if(httpPost.equals(LoggerType.CONSOLE)) {
			logger = new ConsoleOutputLogger();
		} else if(httpPost.equals(LoggerType.JMS)) {
			logger = new JMSOutputLogger();
		}
		return logger;			
	}

}
