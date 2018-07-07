package br.puc.se.designPatterns.structural.databaseToObject;

import java.util.List;

public interface DatabaseUtils {

	static List<LogEvent> getEventsFromEntry(LogEntry entry) {
		// get all events from entries
		return null;
	}
	
	static List<LogEntry> getEntriesFromDate(DateRange range) {
		// list the database and fullfill the entries
		List<LogEntry> entries = null;
		return entries;
	}
	
}
