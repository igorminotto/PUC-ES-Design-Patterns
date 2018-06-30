package br.puc.se.designPatterns.structural.databaseToObject;

import java.util.List;

public interface DatabaseUtils {

	static List<LogEvent> getEventsFromEntry(LogEntry entry) {
		// get all events from entries
		return null;
	}
	
	static List<LogEntry> getentryFromDate(DateRange range) {
		// list the database and fullfill the entries
		List<LogEntry> entries = null;
		// iterate over entries and fill the events
		for (LogEntry entry : entries) {
			List<LogEvent> events = getEventsFromEntry(entry);
			entry.setEvents(events);
		}
		return entries;
	}
	
}
