package br.puc.se.designPatterns.creational.prototype;

public class UserTransaction {

	private String name;
	
	private long transactionId;
	
	public UserTransaction(String line) {
		String[] split = line.split(";");
		this.name = split[0];
		this.transactionId = Long.valueOf(split[1]);
	}

	public String getName() {
		return name;
	}

	public long getTransactionId() {
		return transactionId;
	}

}
