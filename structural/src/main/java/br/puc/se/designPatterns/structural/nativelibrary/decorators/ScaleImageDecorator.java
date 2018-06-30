package br.puc.se.designPatterns.structural.nativelibrary.decorators;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;

public class ScaleImageDecorator extends ImageDecorator {
	private int width;
	private int height;
	
	public ScaleImageDecorator(Image image, int width, int height) {
		super(image);
		this.width = width;
		this.height = height;
	}

	public ImageData getData() {
		this.image.getData().scale(width, height);
		return this.image.getData();
	}

}
