package br.puc.se.designPatterns.structural.nativelibrary.decorators;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;

public class GrayScaleImageDecorator extends ImageDecorator {

	public GrayScaleImageDecorator(Image image) {
		super(image);
	}

	@Override
	public ImageData getData() {
		this.image.getData().toGrayScale();
		return this.image.getData();
	}

}
