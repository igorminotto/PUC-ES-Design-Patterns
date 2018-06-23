package br.puc.se.designPatterns.creational.factory;

public abstract class OutputLogger {

	public void log(String logMessage) {
		String formated = this.formatMessage(logMessage);
		EventEmitter.getInstance().emit(this.getClass().getSimpleName(), formated);
	}
	
	protected abstract String formatMessage(String logMessage);

	@Override
	public boolean equals(Object obj) {
		return this.getClass().getSimpleName().equals(obj.getClass().getSimpleName());
	}
	
	@Override
	public int hashCode() {
		return this.getClass().getSimpleName().hashCode();
	}
	
}
