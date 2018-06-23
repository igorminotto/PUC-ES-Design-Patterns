package br.puc.se.designPatterns.creational.prototype;

import java.util.List;

@FunctionalInterface
public interface TransactionLoader {

	List<UserTransaction> load();
	
}
