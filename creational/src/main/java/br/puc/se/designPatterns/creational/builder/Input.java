package br.puc.se.designPatterns.creational.builder;

@FunctionalInterface
public interface Input<T> {

	T getContent();

}
