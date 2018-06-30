package br.puc.se.designPatterns.structural.currencyConverter.legacy;

public class LegacyCurrencyConverter {
	
	public float convert(PriceProvider provider, float value, String sourceCurrency, String targetCurrency) {
		float factor = provider.getConvertionFactor("my_currency_database", sourceCurrency, targetCurrency);
		return value * factor;
	}

}
