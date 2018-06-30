package br.puc.se.designPatterns.creational.builder;

public class ResourceFileBuilder implements InputBuilder<String> {

	private String resource;
	
	public ResourceFileBuilder fromResource(String resource) {
		this.resource = resource;
		return this;
	}

	@Override
	public Input<String> build() {
		Input<String> input; 
		if(this.resource != null) {
			input = new ResourceFileInput(this.resource);
		} else {
			input = new ResourceFileInput();
		}
		return input;
	}

}
