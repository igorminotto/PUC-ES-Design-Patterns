package br.puc.se.designPatterns.structural.currencyConverter;

@FunctionalInterface
public interface CurrencyOnlinePriceProvider {

	public float onlinePrice(String from, String to);
	
}
