package br.puc.se.designPatterns.creational.builder;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuilderTest {

	@DisplayName("Q1: Can I use a builder to create an object with default values?")
	@Test
	void usingBuilderWithDefaultValuesTest() {
		ResourceFileBuilder builder = new ResourceFileBuilder();
		
		Input<String> input = builder.build();
		String content = input.getContent();
		
		assertThat(content)
		  .isEqualTo("no content");
	}
	
	@DisplayName("Q2: Can I use a builder to read the plain value from [simple-content.txt]?")
	@Test
	void usingBuilderWithSimpleContentTxtTest() {
		ResourceFileBuilder builder = new ResourceFileBuilder();
		builder.fromResource("simple-content.txt");
		
		Input<String> input = builder.build();
		String content = input.getContent();
		
		assertThat(content)
		  .isEqualTo("my great content inside simple-content.txt");
	}
	
	@DisplayName("Q3: Can I configure the httpInput using a builder?")
	@Test
	void httpInputUsingBuilderWithParametersTest() {
		HttpInputBuilder builder = new HttpInputBuilder();
		builder.fromHost("localhost")
			.usingProtocol("http")
			.onPort(10000)
			.usingMethod("GET");
		
		Input<HttpInputConnection> input = builder.build();
		HttpInputConnection content = input.getContent();
		
		assertThat(content.createCURLCommandUsingConnection())
		  .isEqualTo("curl -X GET http:localhost:10000");
	}
	
	@DisplayName("Q4: Can I configure the httpInput using a resource file?")
	@Test
	void httpInputUsingResourceFileTest() throws FileNotFoundException, IOException {
		HttpInputBuilder builder = new HttpInputBuilder();
		builder.fromPropertyFile("network-configuration.properties");
		
		Input<HttpInputConnection> input = builder.build();
		HttpInputConnection content = input.getContent();
		
		assertThat(content.createCURLCommandUsingConnection())
		  .isEqualTo("curl -X post http:localhost:23001");
	}
	
	@DisplayName("Q5: Can I configure the httpInput using a resource file and replace some configuration?")
	@Test
	void httpInputUsingResourceFileWithReplacementTest() throws FileNotFoundException, IOException {
		HttpInputBuilder builder = new HttpInputBuilder();
		builder.fromPropertyFile("network-configuration.properties")
			.fromHost("remote-host")
			.usingProtocol("https")
			.onPort(9090)
			.usingMethod("HEAD");
		
		Input<HttpInputConnection> input = builder.build();
		HttpInputConnection content = input.getContent();
		
		assertThat(content.createCURLCommandUsingConnection())
		  .isEqualTo("curl -X HEAD https:remote-host:9090");
	}

}
