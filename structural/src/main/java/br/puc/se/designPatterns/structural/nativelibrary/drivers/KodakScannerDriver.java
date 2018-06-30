package br.puc.se.designPatterns.structural.nativelibrary.drivers;

public abstract class KodakScannerDriver implements ScannerDriver {

	private ScannerConfig config;

	public KodakScannerDriver(String so) {
		super();
		this.config = new ScannerConfig(so, "kodak", false, false);
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
