package br.puc.se.designPatterns.creational.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public interface BuilderUtilities {

	static Properties readPropertiesFromResourceFile(String resourceFileName)
			throws FileNotFoundException, IOException {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Properties connectionProperties = new Properties();
		File propertyFile = new File(classLoader.getResource(resourceFileName).getFile());
		connectionProperties.load(new FileInputStream(propertyFile));
		return connectionProperties;
	}

}
