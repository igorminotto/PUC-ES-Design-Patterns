package br.puc.se.designPatterns.structural.currencyConverter;

import br.puc.se.designPatterns.structural.currencyConverter.legacy.PriceProvider;

public class PriceProviderAdapter implements PriceProvider {
	private CurrencyOnlinePriceProvider onlinePriceProvider;
	
	public PriceProviderAdapter(CurrencyOnlinePriceProvider onlinePriceProvider) {
		super();
		this.onlinePriceProvider = onlinePriceProvider;
	}

	@Override
	public float getConvertionFactor(String databasename, String currencyName, String targetCurrency) {
		return this.onlinePriceProvider.onlinePrice(currencyName, targetCurrency);
	}

}
