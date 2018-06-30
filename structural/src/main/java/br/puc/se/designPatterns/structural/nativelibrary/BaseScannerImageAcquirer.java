package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerDriver;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

public class BaseScannerImageAcquirer implements ScannerImageAcquirer {
	SO so;
	ScannerBrand scannerBrand;
	ScannerDriver driver;
	
	public BaseScannerImageAcquirer(SO so, ScannerBrand scannerBrand, ScannerDriver driver) {
		super();
		this.so = so;
		this.scannerBrand = scannerBrand;
		this.driver = driver;
	}

	public ImageData getImagesFromScanner() {
		driver.startScannerDevice();
		driver.showScanDialog();
		ImageData scanned = driver.scan();
		return scanned;
	}

	public boolean isScannerPresent() {
		return System.getProperty("imageAcquirer.vendor", "").equals(scannerBrand.toString()) &&
				System.getProperty("imageAcquirer.so", "").equals(so.toString());
	}

}
