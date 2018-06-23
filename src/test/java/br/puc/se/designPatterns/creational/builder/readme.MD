Primeiro exercicio:

Contexto: temos diferentes tipos de Inputs e precisamos configurar varios parametros
para configurar ou ler a configuracao de um arquivo. Sua missao e' criar essa estrutura
de leitura e configuracao do Input.

Retornem uma string:
	ResourceFileBuilder builder = new ResourceFileBuilder();		
	Input<String> input = builder.build();
	String content = input.getContent();

Leiam um arquivo:
	ResourceFileBuilder builder = new ResourceFileBuilder();
	builder.fromResource("simple-content.txt");
	Input<String> input = builder.build();
	String content = input.getContent();
	
Configurem uma conexao com servidor remoto:
	HttpInputBuilder builder = new HttpInputBuilder();
		builder.fromHost("localhost")
			.usingProtocol("http")
			.onPort(10000)
			.usingMethod("GET");
		
	Input<HttpInputConnection> input = builder.build();
	HttpInputConnection content = input.getContent();
	
	
Configure a mesma conexao com servidor remoto utilizando um arquivo de properties:
	HttpInputBuilder builder = new HttpInputBuilder();
	builder.fromPropertyFile("network-configuration.properties");
		
	Input<HttpInputConnection> input = builder.build();
	HttpInputConnection content = input.getContent();