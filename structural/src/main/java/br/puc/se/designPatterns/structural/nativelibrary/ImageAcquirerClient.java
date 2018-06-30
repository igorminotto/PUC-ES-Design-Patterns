package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

// Refactor this to avoid those lot of replicated code
// Tips: #1 [DONE] a controller / facade to abstract the image module
//       #2 [DONE] a factory to create the right imageAcquirer
//       #3 [DONE] a bridge to avoid 6 subclasses of ScannerImageAcquirer and reuse the code from drivers
//       #4 [DONE] a decorator to adjust the image (sizeScale, grayScale, TiffToPNG)
public class ImageAcquirerClient {
	
	public ImageData getImageFromScannerAndSave() {
		ImageController imageController = new ImageController();
		ImageData source = this.getImageFromScanner();
		return imageController.saveImage(source);
	}
	
	private ImageData getImageFromScanner() {
		String so = System.getProperty("imageAcquirer.so", "linux");
		ScannerImageAcquirerFactory factory = new ScannerImageAcquirerFactory();
		ScannerImageAcquirer imageAcquirer = factory.forSO(so);
		ImageData source = imageAcquirer.getImagesFromScanner();
		return source;
	}
}
