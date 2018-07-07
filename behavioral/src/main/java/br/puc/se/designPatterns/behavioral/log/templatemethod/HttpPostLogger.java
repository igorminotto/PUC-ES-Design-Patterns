package br.puc.se.designPatterns.behavioral.log.templatemethod;

import java.util.Date;

import br.puc.se.designPatterns.behavioral.log.LogLevel;
import br.puc.se.designPatterns.behavioral.log.LogListener;

public class HttpPostLogger extends AbstractLogger {
	
	private String uri = "http://localhost:8080";
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public String getUri() {
		return uri;
	}
	
	@Override
	protected String formatMessage(LogLevel messageLevel, String message) {
		return String.format("[Logger: %s on %s]:%s:%s: %s", "HttpPostLogger", this.uri, new Date(), messageLevel, message);
	}

	@Override
	protected void doLog(String formatedMessage) {
		// mocking the http post over internet and notify the listeners
		for (LogListener listener : this.listeners) {
			listener.onLog(formatedMessage);
		}
	}

}

