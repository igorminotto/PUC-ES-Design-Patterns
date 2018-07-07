package br.puc.se.designPatterns.behavioral.log.templatemethod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.puc.se.designPatterns.behavioral.log.LogLevel;
import br.puc.se.designPatterns.behavioral.log.LogListener;

public class TemplateMethodTest {

	@Test
	public void consoleTest() {
		LogListener listener = new LogListener();

		ConsoleLogger templateMethodConsoleLogger = new ConsoleLogger();
		templateMethodConsoleLogger.setLogLevel(LogLevel.ERROR);
		templateMethodConsoleLogger.addListener(listener);

		templateMethodConsoleLogger.log(LogLevel.INFO, "should not log");
		templateMethodConsoleLogger.log(LogLevel.WARNING, "should not log");
		templateMethodConsoleLogger.log(LogLevel.ERROR, "should log");
		templateMethodConsoleLogger.log(LogLevel.FATAL, "should log");

		assertEquals(2, listener.getLogs().size());
	}

	@Test
	public void fileTest() {
		LogListener listener = new LogListener();

		FileLogger templateMethodFileLogger = new FileLogger();
		templateMethodFileLogger.setLogLevel(LogLevel.FATAL);
		templateMethodFileLogger.addListener(listener);

		templateMethodFileLogger.log(LogLevel.INFO, "should not log");
		templateMethodFileLogger.log(LogLevel.WARNING, "should not log");
		templateMethodFileLogger.log(LogLevel.ERROR, "should not log");
		templateMethodFileLogger.log(LogLevel.FATAL, "should log");

		assertEquals(1, listener.getLogs().size());
	}

	@Test
	public void httpTest() {
		LogListener listener = new LogListener();

		HttpPostLogger templateMethodHttpLogger = new HttpPostLogger();
		templateMethodHttpLogger.setLogLevel(LogLevel.INFO);
		templateMethodHttpLogger.addListener(listener);

		templateMethodHttpLogger.log(LogLevel.INFO, "should log");
		templateMethodHttpLogger.log(LogLevel.WARNING, "should log");
		templateMethodHttpLogger.log(LogLevel.ERROR, "should log");
		templateMethodHttpLogger.log(LogLevel.FATAL, "should log");

		assertEquals(4, listener.getLogs().size());
	}

	@Test
	public void consoleMessageTest() {
		LogListener listener = new LogListener();

		ConsoleLogger templateMethodConsoleLogger = new ConsoleLogger();
		templateMethodConsoleLogger.setLogLevel(LogLevel.ERROR);
		templateMethodConsoleLogger.addListener(listener);

		templateMethodConsoleLogger.log(LogLevel.ERROR, "should log");

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

		FileLogger templateMethodFileLogger = new FileLogger();
		templateMethodFileLogger.setLogLevel(LogLevel.ERROR);
		templateMethodFileLogger.addListener(listener);

		templateMethodFileLogger.log(LogLevel.INFO, "should not log");
		templateMethodFileLogger.log(LogLevel.ERROR, "should log");

		assertEquals(1, listener.getLogs().size());
		for (String message : listener.getLogs()) {
			assertTrue("should contains the message ['should log']", message.contains("should log"));
			assertTrue(
					"should contains the logger name '[Logger: FileLogger on "
							+ templateMethodFileLogger.getFileName() + "]'",
					message.contains("[Logger: FileLogger on "+ templateMethodFileLogger.getFileName() +"]"));
			assertTrue("should contains the log level ':ERROR:'", message.contains(":ERROR:"));
		}
	}

	@Test
	public void httpMessageTest() {
		LogListener listener = new LogListener();

		HttpPostLogger templateMethodHttpLogger = new HttpPostLogger();
		templateMethodHttpLogger.setLogLevel(LogLevel.DEBUG);
		templateMethodHttpLogger.addListener(listener);

		templateMethodHttpLogger.log(LogLevel.DEBUG, "should log");

		assertEquals(1, listener.getLogs().size());
		for (String message : listener.getLogs()) {
			assertTrue("should contains the message ['should log']", message.contains("should log"));
			assertTrue(
					"should contains the logger name '[Logger: HttpPostLogger on "
							+ templateMethodHttpLogger.getUri() + "]'",
					message.contains("[Logger: HttpPostLogger on "+ templateMethodHttpLogger.getUri() +"]"));
			assertTrue("should contains the log level ':DEBUG:'", message.contains(":DEBUG:"));
		}
	}

}
