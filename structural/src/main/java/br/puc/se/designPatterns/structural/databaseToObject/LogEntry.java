package br.puc.se.designPatterns.structural.databaseToObject;

import java.util.Date;
import java.util.List;

public class LogEntry {
	
	private List<LogEvent> events = null;
	
	private Date timestamp;

	public List<LogEvent> getEvents() {
		if(this.events == null) {
			List<LogEvent> events = DatabaseUtils.getEventsFromEntry(this);
			this.setEvents(events);
		}
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
