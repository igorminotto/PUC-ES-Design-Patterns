package br.puc.se.designPatterns.structural.nativelibrary.drivers;

public abstract class CannonScannerDriver implements ScannerDriver {

	private ScannerConfig config;

	public CannonScannerDriver(String so) {
		super();
		this.config = new ScannerConfig(so, "cannon", false, false);
	}

	public void startScannerDevice() {
		config.start();
	}

	public void showScanDialog() {
		config.configure();
	}

	public ImageData scan() {
		return new ImageData(config);
	}

}
