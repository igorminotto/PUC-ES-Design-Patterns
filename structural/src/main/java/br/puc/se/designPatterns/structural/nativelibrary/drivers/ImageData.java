package br.puc.se.designPatterns.structural.nativelibrary.drivers;

public class ImageData {

	private boolean color = true;
	
	private String fileName = "";
	
	private int width;
	
	private int height;
	
	private String format = "tiff";

	private ScannerConfig scannerConfig;
	
	public ImageData(ScannerConfig scannerConfig) {
		this.scannerConfig = scannerConfig;
	}
	
	public ImageData toGrayScale() {
		this.color = false;
		return this;
	}

	public ImageData saveToFile(String fileNameToSave) {
		this.fileName = fileNameToSave;
		return this;
	}

	public ImageData scale(int width, int height) {
		this.width = width;
		this.height = height;
		return this;
	}

	public ImageData convertToPNG() {
		this.format = "png";
		return this;
	}

	public boolean isColor() {
		return color;
	}

	public String getFileName() {
		return fileName;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getFormat() {
		return format;
	}
	
	public ScannerConfig getScannerConfig() {
		return scannerConfig;
	}
	
}
