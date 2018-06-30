package br.puc.se.designPatterns.structural.nativelibrary.decorators;

public abstract class ImageDecorator implements Image {

	protected Image image;

	public ImageDecorator(Image image) {
		super();
		this.image = image;
	}

}
