package br.puc.se.designPatterns.creational.prototype;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrototypeTest {

	@DisplayName("Q1: Can I reuse the loaded content?")
	@Test
	void reuseTheSameContentTest() {
		BlockChainTransactionLoader messageLoader = new BlockChainTransactionLoader();
		List<UserTransaction> transactions = messageLoader.loadTransactionsFromFile("user-blockchain-transactions.txt");
		
		// find a transaction by its ID
		TransactionFinder finder = new TransactionFinder(transactions);
		Optional<UserTransaction> foundTransaction = finder.findById(21024);
		assertThat(foundTransaction.isPresent()).isTrue();
		
		// match the transactions on user wallets
		WalletMatcher matcher = new WalletMatcher(transactions);
		List<UserWallet> wallets = matcher.groupTransactionsByName();
		
		assertThat(wallets).isNotEmpty();
		
		// some troll clear the list
		transactions.clear();
		
		foundTransaction = finder.findById(21024);
		assertThat(foundTransaction.isPresent()).isFalse();
	}
	
	@DisplayName("Q2: Can I reuse the loaded content avoiding side effects?")
	@Test
	void reuseTheSameContentWithouSideEffectsTest() {
		
		// find a transaction by its ID
		BlockChainTransactionLoader messageLoader = new BlockChainTransactionLoader();
		TransactionFinder finder = new TransactionFinder(() -> {
			return messageLoader.loadTransactionsFromFile("user-blockchain-transactions.txt");
		});
		Optional<UserTransaction> foundTransaction = finder.findById(21024);
		assertThat(foundTransaction.isPresent()).isTrue();

		// match the transactions on user wallets
		BlockChainTransactionLoader clone = messageLoader.deepCopy();
		WalletMatcher matcher = new WalletMatcher(() -> {
			return clone.loadTransactionsFromFile("user-blockchain-transactions.txt");
		});
		List<UserWallet> wallets = matcher.groupTransactionsByName();
		assertThat(wallets).isNotEmpty();
	}
	
	@DisplayName("FYI: Can we isolate even more?")
	@Test
	void avoidingSideEffectsIITest() {
		BlockChainTransactionLoader messageLoader = new BlockChainTransactionLoader();
		String fileName = "user-blockchain-transactions.txt";
		
		Optional<UserTransaction> foundTransaction = findTransaction(messageLoader, fileName, 21024);
		assertThat(foundTransaction.isPresent()).isTrue();
		
		List<UserWallet> wallets = loadWallets(messageLoader, fileName);
		assertThat(wallets).isNotEmpty();
	}
	
	// Q:3 Can we use the builder pattern here? If yes, do it! :D
	
	private Optional<UserTransaction> findTransaction(BlockChainTransactionLoader messageLoader, String fileName, long transactionId) {
		TransactionFinder finder = new TransactionFinder(() -> {
			return messageLoader.loadTransactionsFromFile(fileName);
		});
		return finder.findById(transactionId);
	}
	
	private List<UserWallet> loadWallets(BlockChainTransactionLoader messageLoader, String fileName) {
		WalletMatcher matcher = new WalletMatcher(() -> {
			return messageLoader.loadTransactionsFromFile(fileName);
		});
		return matcher.groupTransactionsByName();
	}

}
