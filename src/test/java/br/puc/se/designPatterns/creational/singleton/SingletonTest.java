package br.puc.se.designPatterns.creational.singleton;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SingletonTest {
	
	@DisplayName("Q1: Can I call the singleton twice and get the same reference?")
	@Test
	void httpInputUsingResourceFileWithReplacementTest() {
		MyCustomApplicationContext context = MyCustomApplicationContext.getInstance();
		assertThat(context)
		  .isSameAs(MyCustomApplicationContext.getInstance());
	}
	
	@DisplayName("Q2: Can I call the construtor by hand?")
	@Test
	void callingTheConstructorByHandTest() throws InstantiationException {
		try {
			MyCustomApplicationContext.class.newInstance();
		} catch (IllegalAccessException e) {
			return;
		}
		fail("cannot access the constructor by hand!");
	}
	
	@DisplayName("Q3: Is it thread safe?")
	@Test
	void isThreadSafeTest() throws InstantiationException {
		// http://www.baeldung.com/java-singleton more about singleton thread safety

		Set<MyCustomApplicationContext> collected = IntStream.range(0, 100)
			.parallel()
			.mapToObj((value) -> MyCustomApplicationContext.getInstance())
			.collect(Collectors.toSet());
		
		assertThat(collected.size())
			.isEqualTo(1);
	}

}
