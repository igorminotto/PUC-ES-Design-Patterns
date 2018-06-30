package br.puc.se.designPatterns.structural.currencyConverter;

public class CurrencyValue {
	
	private float value;
	
	private String currencyName;

	public CurrencyValue(float value, String currencyName) {
		super();
		this.value = value;
		this.currencyName = currencyName;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

}
