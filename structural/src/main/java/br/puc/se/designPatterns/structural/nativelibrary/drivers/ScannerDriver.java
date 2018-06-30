package br.puc.se.designPatterns.structural.nativelibrary.drivers;

public interface ScannerDriver {
	
	public void startScannerDevice();

	public void showScanDialog();

	public ImageData scan();
	
}
