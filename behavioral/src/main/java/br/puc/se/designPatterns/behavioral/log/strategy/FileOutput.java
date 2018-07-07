package br.puc.se.designPatterns.behavioral.log.strategy;

import java.util.Date;

import br.puc.se.designPatterns.behavioral.log.LogLevel;

public class FileOutput implements OutputStrategy {

	private String fileName = "./output.log";
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String formatMessage(LogLevel messageLevel, String message) {
		return String.format("[Logger: %s on %s]:%s:%s: %s", "FileLogger", this.fileName, new Date(), messageLevel, message);
	}

	public void doLog(String formatedMessage) {
		// mocking the print on the log file and notify the listeners
	}
	
}


