package br.puc.se.designPatterns.creational.prototype;

import java.util.List;
import java.util.Optional;

public class TransactionFinder {

	private List<UserTransaction> transactions;
	
	public TransactionFinder(TransactionLoader loader) {
		this.transactions = loader.load();
	}
	
	public TransactionFinder(List<UserTransaction> transactions) {
		this.transactions = transactions;
	}

	public Optional<UserTransaction> findById(long id) {
		Optional<UserTransaction> findFirst = transactions.stream().filter((trx) -> {
			return trx.getTransactionId() == id;
		}).findFirst();
		return findFirst;
	}

}
