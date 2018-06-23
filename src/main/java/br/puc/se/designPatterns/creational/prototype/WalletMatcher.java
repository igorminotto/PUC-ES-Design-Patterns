package br.puc.se.designPatterns.creational.prototype;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class WalletMatcher {

	private List<UserTransaction> transactions;

	public Optional<UserTransaction> findById(long id) {
		Optional<UserTransaction> findFirst = transactions.stream().filter((trx) -> {
			return trx.getTransactionId() == id;
		}).findFirst();
		return findFirst;
	}
	
	public WalletMatcher(TransactionLoader loader) {
		this.transactions = loader.load();
	}
	
	public WalletMatcher(List<UserTransaction> transactions) {
		this.transactions = transactions;
	}

	public List<UserWallet> groupTransactionsByName() {
		Map<String, List<UserTransaction>> collect = this.transactions.stream()
				.collect(Collectors.groupingBy((trx) -> trx.getName()));
		
		return collect.keySet().stream()
				.map((key) -> new UserWallet(key, collect.get(key)))
				.collect(Collectors.toList()); 
	}

}
