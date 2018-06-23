package br.puc.se.designPatterns.creational.prototype;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BlockChainTransactionLoader {
	
	HashMap<String, List<UserTransaction>> cache;
	
	public BlockChainTransactionLoader() {
		super();
		this.cache = new HashMap<String, List<UserTransaction>>();
	}
	
	private BlockChainTransactionLoader(HashMap<String, List<UserTransaction>> cache) {
		super();
		this.cache = cache;
	}
	
	public BlockChainTransactionLoader deepCopy() {
		return new BlockChainTransactionLoader(this.cache);
	}

	public List<UserTransaction> loadTransactionsFromFile(String fileName) {
		if(this.cache.containsKey(fileName)) {
			return this.cache.get(fileName);
		}
		return loadTheMessages(fileName);
	}
	
	private List<UserTransaction> loadTheMessages(String fileName) {
		try {
			Thread.sleep(6);
			return PrototypeUtils.readLinesFromResource(fileName);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return new LinkedList<>();
	}
	
}
