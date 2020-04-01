package org.ftoth.testing;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest
{
	@BeforeAll
	static void init() {
		System.out.println("INIT");
	}

	@AfterAll
	static void cleanup() {
		System.out.println("CLEANUP");
	}

	@BeforeEach
	void initBeforeEveryTest(TestInfo info) {
		System.out.println("INIT-EVERY: " + info.getDisplayName());
	}

	@AfterEach
	void cleanupBeforeEveryTest(TestInfo info) {
		System.out.println("CLEANUP-EVERY: " + info.getDisplayName());
	}

	@Test
	void test1() {
	}

	@Test
	@DisplayName("Testing throwing NPE")
	void test2() {
		assertThrows(NullPointerException.class, () -> {
			String s = null;
			s.length();
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"abc", "def", "xy"})
	@DisplayName("Parameterized test for string length()")
	void test3(String s) {
		assertTrue(s.length() >0);
	}

	@ParameterizedTest(name = "{0} length is {1}")
	@CsvSource(value = {"abc, 3", "xy, 2", "'', 0"})
	//@CsvSource(value = {"abc, 3", "xy, 2", "'', 0", "123, 4"})		// fails
	@DisplayName("Parameterized test from CSV")
	void test4(String word, int len) {
		assertEquals(len, word.length());
	}

	@RepeatedTest(10)
	void repeateThisTest() {
		assertTrue("abcdef".contains("ab"));
	}

	@Test
	void performanceTest() {
		assertTimeout(Duration.ofSeconds(3), () -> {
			for (int n=0; n<1000000; n++) {
				//System.out.println("counter:" + n);		// uncomment than fails
			}
		});
	}

	@Test
	@Disabled
	void disableThisTest() {

	}
}
