package br.puc.se.designPatterns.creational.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FactoryTest {
	
	@DisplayName("Q1: Can I send the logs over HTTP POST?")
	@Test
	void logOverHttpTest() {
		List<String> messages = new LinkedList<>();
		EventEmitter emitter = EventEmitter.getInstance();
		emitter.on("HTTPOutputLogger", (message) -> messages.add(message));
		
		LogFactory factory = new LogFactory();
		OutputLogger httpLogger = factory.of(LoggerType.HTTP_POST);
		System.out.println(httpLogger);
		httpLogger.log("1");
		
		assertThat(messages.size()).isEqualTo(1);
	}
	
	@DisplayName("Q2: Can I send the logs over HTTP POST and CONSOLE?")
	@Test
	void logOverHttpAndConsolehttpTest() {
		List<String> httpMessages = new LinkedList<>();
		List<String> consoleMessages = new LinkedList<>();
		EventEmitter emitter = EventEmitter.getInstance();
		emitter.on("HTTPOutputLogger", (message) -> httpMessages.add(message));
		emitter.on("ConsoleOutputLogger", (message) -> consoleMessages.add(message));
		
		LogFactory factory = new LogFactory();
		OutputLogger httpLogger = factory.of(LoggerType.HTTP_POST);
		httpLogger.log("1");
		OutputLogger console = factory.of(LoggerType.CONSOLE);
		console.log("10");
		assertThat(consoleMessages.size()).isEqualTo(1);
		assertThat(httpMessages.size()).isEqualTo(1);
	}
	
	@DisplayName("Q3: Can I send multiple log entries over JMS?")
	@Test
	void logOverJMSTest() {
		List<String> messages = new LinkedList<>();
		EventEmitter emitter = EventEmitter.getInstance();
		emitter.on("JMSOutputLogger", (message) -> messages.add(message));
		
		LogFactory factory = new LogFactory();
		OutputLogger httpLogger = factory.of(LoggerType.JMS);
		httpLogger.log("1");
		httpLogger.log("3");
		httpLogger.log("4");
		httpLogger.log("5");
		httpLogger.log("10");
		assertThat(messages.size()).isEqualTo(5);
	}
	
}
