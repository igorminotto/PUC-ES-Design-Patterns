package br.puc.se.designPatterns.structural.nativelibrary.decorators;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;

public class TIFFtoPNGImageDecorator extends ImageDecorator {

	public TIFFtoPNGImageDecorator(Image image) {
		super(image);
	}

	public ImageData getData() {
		this.image.getData().convertToPNG();
		return this.image.getData();
	}

}
