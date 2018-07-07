package br.puc.se.designPatterns.behavioral.log.templatemethod;

import java.util.Date;

import br.puc.se.designPatterns.behavioral.log.LogLevel;
import br.puc.se.designPatterns.behavioral.log.LogListener;

public class FileLogger extends AbstractLogger {
	
	private String fileName = "./output.log";
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	@Override
	protected String formatMessage(LogLevel messageLevel, String message) {
		return String.format("[Logger: %s on %s]:%s:%s: %s", "FileLogger", this.fileName, new Date(), messageLevel, message);
	}

	@Override
	protected void doLog(String formatedMessage) {
		// mocking the print on the log file and notify the listeners
		for (LogListener listener : this.listeners) {
			listener.onLog(formatedMessage);
		}
	}

}


