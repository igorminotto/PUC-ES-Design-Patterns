package br.puc.se.designPatterns.structural.nativelibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerConfig;

public class ImageAcquirerTest {

	@Test
	public void kodakWinImageAcquirerTest() {
		String fileName = "/data/images/1.png";
		String vendor = "kodak";
		String so = "windows";
		doTest(so, vendor, fileName);
	}
	
	@Test
	public void kodakLinuxImageAcquirerTest() {
		String fileName = "/data/images/1.png";
		String vendor = "kodak";
		String so = "linux";
		doTest(so, vendor, fileName);
	}
	
	@Test
	public void cannonMacImageAcquirerTest() {
		String fileName = "/data/images/1.png";
		String vendor = "cannon";
		String so = "mac";
		doTest(so, vendor, fileName);
	}
	
	@Test
	public void kodakMacImageAcquirerTest() {
		String fileName = "/data/images/1.png";
		String vendor = "kodak";
		String so = "mac";
		doTest(so, vendor, fileName);
	}
	
	@Test
	public void cannonLinuxImageAcquirerTest() {
		String fileName = "/data/images/1.png";
		String vendor = "cannon";
		String so = "linux";
		doTest(so, vendor, fileName);
	}
	
	private void doTest(String so, String vendor, String fileName) {
		configEnv(so, vendor);
		ImageAcquirerClient imageAcquirerClient = new ImageAcquirerClient();
		ImageData saved = imageAcquirerClient.getImageFromScannerAndSave();
		ScannerConfig scannerConfig = saved.getScannerConfig();
		assertEquals(scannerConfig.getSystem(), so);
		assertEquals(scannerConfig.getVendor(), vendor);
		
		assertEquals(saved.getFileName(), fileName);
		assertTrue(saved.getScannerConfig().isConfigured());
		assertTrue(saved.getScannerConfig().isStarted());
	}
	
	private void configEnv(String so, String vendor) {
		System.setProperty("imageAcquirer.vendor", vendor);
		System.setProperty("imageAcquirer.so", so);
	}
	
}
