package br.puc.se.designPatterns.behavioral.log.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.puc.se.designPatterns.behavioral.log.LogLevel;
import br.puc.se.designPatterns.behavioral.log.LogListener;
import br.puc.se.designPatterns.behavioral.log.strategy.ConsoleOutput;
import br.puc.se.designPatterns.behavioral.log.strategy.FileOutput;
import br.puc.se.designPatterns.behavioral.log.strategy.HttpPostOutput;

public class StrategyTest {

	@Test
	public void consoleTest() {
		LogListener listener = new LogListener();

		ConcreteLogger strategyConsoleLogger = new ConcreteLogger(new ConsoleOutput());
		strategyConsoleLogger.setLogLevel(LogLevel.ERROR);
		strategyConsoleLogger.addListener(listener);

		strategyConsoleLogger.log(LogLevel.INFO, "should not log");
		strategyConsoleLogger.log(LogLevel.WARNING, "should not log");
		strategyConsoleLogger.log(LogLevel.ERROR, "should log");
		strategyConsoleLogger.log(LogLevel.FATAL, "should log");

		assertEquals(2, listener.getLogs().size());
	}

	@Test
	public void fileTest() {
		LogListener listener = new LogListener();

		ConcreteLogger strategyFileLogger = new ConcreteLogger(new FileOutput());
		strategyFileLogger.setLogLevel(LogLevel.FATAL);
		strategyFileLogger.addListener(listener);

		strategyFileLogger.log(LogLevel.INFO, "should not log");
		strategyFileLogger.log(LogLevel.WARNING, "should not log");
		strategyFileLogger.log(LogLevel.ERROR, "should not log");
		strategyFileLogger.log(LogLevel.FATAL, "should log");

		assertEquals(1, listener.getLogs().size());
	}

	@Test
	public void httpTest() {
		LogListener listener = new LogListener();

		ConcreteLogger strategyHttpLogger = new ConcreteLogger(new HttpPostOutput());
		strategyHttpLogger.setLogLevel(LogLevel.INFO);
		strategyHttpLogger.addListener(listener);

		strategyHttpLogger.log(LogLevel.INFO, "should log");
		strategyHttpLogger.log(LogLevel.WARNING, "should log");
		strategyHttpLogger.log(LogLevel.ERROR, "should log");
		strategyHttpLogger.log(LogLevel.FATAL, "should log");

		assertEquals(4, listener.getLogs().size());
	}

	@Test
	public void consoleMessageTest() {
		LogListener listener = new LogListener();

		ConcreteLogger strategyConsoleLogger = new ConcreteLogger(new ConsoleOutput());
		strategyConsoleLogger.setLogLevel(LogLevel.ERROR);
		strategyConsoleLogger.addListener(listener);

		strategyConsoleLogger.log(LogLevel.ERROR, "should log");

		assertEquals(1, listener.getLogs().size());
		for (String message : listener.getLogs()) {
			assertTrue("should contains the message ['should log']", message.contains("should log"));
			assertTrue("should contains the logger name '[Logger: ConsoleLogger]'",
					message.contains("[Logger: ConsoleLogger]"));
			assertTrue("should contains the log level ':ERROR:'", message.contains(":ERROR:"));
		}
	}

	@Test
	public void fileMessageTest() {
		LogListener listener = new LogListener();

		ConcreteLogger strategyFileLogger = new ConcreteLogger(new FileOutput());
		strategyFileLogger.setLogLevel(LogLevel.ERROR);
		strategyFileLogger.addListener(listener);

		strategyFileLogger.log(LogLevel.INFO, "should not log");
		strategyFileLogger.log(LogLevel.ERROR, "should log");

		assertEquals(1, listener.getLogs().size());
		for (String message : listener.getLogs()) {
			FileOutput output = (FileOutput) strategyFileLogger.getOutput();
			
			assertTrue("should contains the message ['should log']", message.contains("should log"));
			assertTrue(
					"should contains the logger name '[Logger: FileLogger on "
							+ output.getFileName() + "]'",
					message.contains("[Logger: FileLogger on "+ output.getFileName() +"]"));
			assertTrue("should contains the log level ':ERROR:'", message.contains(":ERROR:"));
		}
	}

	@Test
	public void httpMessageTest() {
		LogListener listener = new LogListener();

		ConcreteLogger strategyHttpLogger = new ConcreteLogger(new HttpPostOutput());
		strategyHttpLogger.setLogLevel(LogLevel.DEBUG);
		strategyHttpLogger.addListener(listener);

		strategyHttpLogger.log(LogLevel.DEBUG, "should log");

		assertEquals(1, listener.getLogs().size());
		for (String message : listener.getLogs()) {
			HttpPostOutput output = (HttpPostOutput) strategyHttpLogger.getOutput();
			
			assertTrue("should contains the message ['should log']", message.contains("should log"));
			assertTrue(
					"should contains the logger name '[Logger: HttpPostLogger on "
							+ output.getUri() + "]'",
					message.contains("[Logger: HttpPostLogger on "+ output.getUri() +"]"));
			assertTrue("should contains the log level ':DEBUG:'", message.contains(":DEBUG:"));
		}
	}

}
