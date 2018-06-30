package br.puc.se.designPatterns.structural.nativelibrary.decorators;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;

public class ImageDataBuilder {
	public Image image;

	public ImageDataBuilder(ImageData data) {
		super();
		this.image = new BaseImage(data);
	}
	
	public ImageDataBuilder convertToPNG() {
		this.image = new TIFFtoPNGImageDecorator(image);
		return this;
	}
	
	public ImageDataBuilder convertToGrayScale() {
		this.image = new GrayScaleImageDecorator(image);
		return this;
	}
	
	public ImageDataBuilder scale(int width, int height) {
		this.image = new ScaleImageDecorator(image, width, height);
		return this;
	}
	
	public ImageData build() {
		return this.image.getData();
	}
}
