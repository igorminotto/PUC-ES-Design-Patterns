package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerDriver;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.so.LinuxCannonScannerDriver;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.so.LinuxKodakScannerDriver;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.so.MacCannonScannerDriver;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.so.MacKodakScannerDriver;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.so.WindowsCannonScannerDriver;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.so.WindowsKodakScannerDriver;

public class ScannerImageAcquirerFactory {

	public ScannerImageAcquirer forSO(String soString) {
		SO so = SO.valueOf(soString);
		return this.forSO(so);
	}
	
	public ScannerImageAcquirer forSO(SO so) {
		ScannerImageAcquirer imageAcquirer = null;
		imageAcquirer = this.kodakScannerImageAcquirerFor(so);
		if (!imageAcquirer.isScannerPresent()) {
			imageAcquirer = this.cannonScannerImageAcquirerFor(so);
		}
		return imageAcquirer;
	}
	
	private ScannerImageAcquirer kodakScannerImageAcquirerFor(SO so) {
		ScannerDriver driver = null;
		if(so.equals(SO.linux)) {
			driver = new LinuxKodakScannerDriver();
		} else if(so.equals(SO.mac)) {
			driver = new MacKodakScannerDriver();
		} else if(so.equals(SO.windows)) {
			driver = new WindowsKodakScannerDriver();
		}  
		return new BaseScannerImageAcquirer(so, ScannerBrand.kodak, driver);
	}
	
	private ScannerImageAcquirer cannonScannerImageAcquirerFor(SO so) {
		ScannerDriver driver = null;
		if(so.equals(SO.linux)) {
			driver = new LinuxCannonScannerDriver();
		} else if(so.equals(SO.mac)) {
			driver = new MacCannonScannerDriver();
		} else if(so.equals(SO.windows)) {
			driver = new WindowsCannonScannerDriver();
		}  
		return new BaseScannerImageAcquirer(so, ScannerBrand.cannon, driver);
	}
}
