package br.puc.se.designPatterns.structural.nativelibrary.decorators;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;

public class BaseImage implements Image {
	
	private ImageData data;

	public BaseImage(ImageData data) {
		super();
		this.data = data;
	}

	public ImageData getData() {
		return this.data;
	}
	
}
