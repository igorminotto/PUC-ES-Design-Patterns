package br.puc.se.designPatterns.structural.currencyConverter.legacy;

public class LegacyCurrencyConverterService {
	
	public float convert(float value, String source, String target) {
		LegacyCurrencyConverter legacyCurrencyConverter = new LegacyCurrencyConverter();
		PriceProvider priceProvider = new LegacyDatabasePriceProvider();
		return legacyCurrencyConverter.convert(priceProvider, value, source, target);
	}

}
