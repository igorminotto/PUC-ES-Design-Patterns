package br.puc.se.designPatterns.structural.nativelibrary.drivers.so;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerConfig;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerDriver;

public class WindowsKodakScannerDriver implements ScannerDriver {

	private ScannerConfig config = new ScannerConfig("windows", "kodak", false, false);

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
