package br.puc.se.designPatterns.creational.prototype;

import java.util.List;

public class UserWallet {

	private String userName;
	
	private List<UserTransaction> list;

	public UserWallet(String userName, List<UserTransaction> list) {
		this.userName = userName;
		this.list = list;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<UserTransaction> getList() {
		return list;
	}

	public void setList(List<UserTransaction> list) {
		this.list = list;
	}

}
