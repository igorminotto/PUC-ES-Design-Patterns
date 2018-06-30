package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.decorators.ImageDataBuilder;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;

public class ImageController {
	private static int width = 640;	
	private static int height = 480;
	
	public ImageData saveImage(ImageData source) {
		ImageData scaled = new ImageDataBuilder(source)
				.convertToPNG()
				.convertToGrayScale()
				.scale(width, height)
				.build();
		
		return this.saveImageOnDatabase(scaled, this.getFileNameToSave());
	}

	private ImageData saveImageOnDatabase(ImageData scaled, String fileNameToSave) {
		return scaled.saveToFile(fileNameToSave);
	}

	private String getFileNameToSave() {
		return "/data/images/1.png";
	}
}
