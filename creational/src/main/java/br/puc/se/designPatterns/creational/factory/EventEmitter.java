package br.puc.se.designPatterns.creational.factory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class EventEmitter {
	
	private static Optional<EventEmitter> INSTANCE = Optional.empty();
	
	public static EventEmitter getInstance() {
		if (!INSTANCE.isPresent()) {
			INSTANCE = Optional.of(new EventEmitter());
		}
		return INSTANCE.get();
	}
	
	private Map<String, Set<LogListener>> messageListeners;
	
	private EventEmitter() {
		this.messageListeners = new HashMap<>();
	}
	
	public void on(String key, LogListener listener) {
		if (!this.messageListeners.containsKey(key)) {
			this.messageListeners.put(key, new HashSet<>());
		}
		this.messageListeners.get(key).add(listener);
	}
	
	public void emit(String key, String message) {
		for (LogListener l : this.messageListeners.get(key)) {
			l.act(message);
		}
	};
	
}
