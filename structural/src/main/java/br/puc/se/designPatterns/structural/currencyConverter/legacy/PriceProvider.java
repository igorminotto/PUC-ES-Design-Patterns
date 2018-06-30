package br.puc.se.designPatterns.structural.currencyConverter.legacy;

public interface PriceProvider {

	float getConvertionFactor(String databasename, String currencyName, String targetCurrency);
	
}
