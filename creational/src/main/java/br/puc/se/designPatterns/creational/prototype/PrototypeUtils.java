package br.puc.se.designPatterns.creational.prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public interface PrototypeUtils {

	static List<UserTransaction> readLinesFromResource(String resourceFileName)
			throws FileNotFoundException, IOException {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File propertyFile = new File(classLoader.getResource(resourceFileName).getFile());
		try (InputStream inputFS = new FileInputStream(propertyFile)) {
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
			return br.lines().map((line) -> {
				return new UserTransaction(line);
			}).collect(Collectors.toList());
		}
	}

}
