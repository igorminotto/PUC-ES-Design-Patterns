package br.puc.se.designPatterns.creational.builder;

import java.util.Properties;

public class HttpInput implements Input<HttpInputConnection> {

	private String host;
	private String port;
	private String protocol;
	private String method;
	
	public HttpInput(String host, String port, String protocol, String method) {
		super();
		this.host = host;
		this.port = port;
		this.protocol = protocol;
		this.method = method;
	}
	
	public HttpInput(String host, int port, String protocol, String method) {
		this(host, String.valueOf(port), protocol, method);
	}

	public HttpInput(Properties properties) {
		super();
		this.host = properties.getProperty("host");
		this.port = properties.getProperty("port");
		this.protocol = properties.getProperty("protocol");
		this.method = properties.getProperty("method");
	}

	@Override
	public HttpInputConnection getContent() {
		HttpInputConnection connection = new HttpInputConnection();
		
		connection.setHost(this.host);
		connection.setPort(this.port);
		connection.setProtocol(this.protocol);
		connection.setMethod(this.method);
		
		return connection;
	}

}
