package br.puc.se.designPatterns.structural.currencyConverter;

import br.puc.se.designPatterns.structural.currencyConverter.legacy.LegacyCurrencyConverter;
import br.puc.se.designPatterns.structural.currencyConverter.legacy.PriceProvider;

// Adapting an onlinePriceProvider and the new CurrencyValue object 
// and use the same legacy code
// that we have in some old library
public class CurrencyConverterService {
	
	private CurrencyOnlinePriceProvider onlineProvider;
	
	public CurrencyValue convert(CurrencyValue value, String targetCurrency) {
		// create an adapter to call the legacy converter using a online price provider	
		LegacyCurrencyConverter legacyCurrencyConverter = new LegacyCurrencyConverter();
		PriceProvider priceProvider = new PriceProviderAdapter(onlineProvider);
		float converted = legacyCurrencyConverter.convert(priceProvider, value.getValue(), value.getCurrencyName(), targetCurrency);
		return new CurrencyValue(converted, targetCurrency);
	}
	
	public void setOnlineProvider(CurrencyOnlinePriceProvider onlineProvider) {
		this.onlineProvider = onlineProvider;
	}

}
