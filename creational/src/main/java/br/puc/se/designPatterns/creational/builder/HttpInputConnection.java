package br.puc.se.designPatterns.creational.builder;

public class HttpInputConnection {

	private String protocol;

	private String host;

	private String port;

	private String method;

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String createCURLCommandUsingConnection() {
		return String.format("curl -X %s %s:%s:%s", this.method, this.protocol, this.host, this.port);
	}

}
