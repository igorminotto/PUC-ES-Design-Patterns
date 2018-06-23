package br.puc.se.designPatterns.creational.builder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HttpInputBuilder implements InputBuilder<HttpInputConnection> {
	
	private String host;
	private String port;
	private String protocol;
	private String method;
	
	public HttpInputBuilder fromPropertyFile(String fileName) throws FileNotFoundException, IOException {
		Properties properties = BuilderUtilities.readPropertiesFromResourceFile(fileName);
		
		String host = properties.getProperty("host");
		String port = properties.getProperty("port");
		String protocol = properties.getProperty("protocol");
		String method = properties.getProperty("method");
		
		return this
				.fromHost(host)
				.onPort(port)
				.usingProtocol(protocol)
				.usingMethod(method);
	}
	
	public HttpInputBuilder fromHost(String host) {
		this.host = host;
		return this;
	}
	
	public HttpInputBuilder usingProtocol(String protocol) {
		this.protocol = protocol;
		return this;
	}
	
	public HttpInputBuilder onPort(int port) {
		return this.onPort(String.valueOf(port));
	}
	
	public HttpInputBuilder onPort(String port) {
		this.port = port;
		return this;
	}
	
	public HttpInputBuilder usingMethod(String method) {
		this.method = method;
		return this;
	}

	@Override
	public Input<HttpInputConnection> build() {
		Input<HttpInputConnection> input = new HttpInput(this.host, this.port, this.protocol, this.method);
		return input;
	}

}
