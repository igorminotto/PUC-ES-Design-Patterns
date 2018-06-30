package br.puc.se.designPatterns.creational.factory;

@FunctionalInterface
public interface LogListener {

	void act(String logMessage);
	
}
