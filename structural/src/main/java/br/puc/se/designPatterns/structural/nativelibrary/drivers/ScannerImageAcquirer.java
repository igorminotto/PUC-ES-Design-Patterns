package br.puc.se.designPatterns.structural.nativelibrary.drivers;

public interface ScannerImageAcquirer {
	
	public ImageData getImagesFromScanner();

	public boolean isScannerPresent();

}
