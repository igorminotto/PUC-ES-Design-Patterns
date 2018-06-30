package br.puc.se.designPatterns.structural.databaseToObject;

import java.util.Date;
import java.util.List;

public class LogEntry {
	
	private List<LogEvent> events;
	
	private Date timestamp;

	public List<LogEvent> getEvents() {
		return events;
	}

	public void setEvents(List<LogEvent> events) {
		this.events = events;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
