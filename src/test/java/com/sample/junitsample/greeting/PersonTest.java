package com.sample.junitsample.greeting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * The Class PersonTest.
 */

class PersonTest implements PersonTests{

	/** The person. */
	Person person;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Disabled
	@BeforeEach
	void setUp() throws Exception {
		person = new Person("Ram", "Kumar");
	}

	/**
	 * Grouped assertions.
	 */
	@Disabled
	@Test
	@DisplayName("Check Name Values")
	void groupedAssertions() {
		assertAll("grouped assertions...", 
				() -> assertEquals("Ram", person.getFirstName(), "First Name assertion failed"),
				() -> assertEquals("Kumar", person.getLastName(), "Last Name assertion Failed"));
	}

	/**
	 * Nested assertions.
	 */
	@Disabled
	@Test
	@DisplayName("Check Name and other Values")
	void nestedAssertions() {
		person.setCity("Kolkata");
		person.setPhoneNumber(1234567890);
		assertAll("nested assertions...",
				() -> assertAll("name assertions",
						() -> assertEquals("Ram", person.getFirstName(), "First name did not match"),
						() -> assertEquals("Kumar", person.getLastName(), "Last name did not match")),
				() -> assertAll("other details assertions",
						() -> assertEquals("Kolkata", person.getCity(), "City name did not match"),
						() -> assertEquals(1234567890, person.getPhoneNumber(), "Phone number did not match"))
		);
	}
	
	@RepeatedTest(value=5, name="{displayName} : {currentRepetition} - {totalRepetitions}")
	@DisplayName("My repeat test")
	void repeatTest() {
		//do nothing
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Ram", "Rama", "Shyam"})
	void parameterTest(String value) {
		System.out.println(value);
	}
	
	@DisplayName("ParameterizedEnumTest")
	@ParameterizedTest(name = "{displayName} - {index} : {argumentsWithNames}")
	@EnumSource(PersonEnum.class)
	void parameterEnumTest(PersonEnum eunm) {
		System.out.println(eunm);
	}
	
	@ParameterizedTest
	@CsvSource(value = { 
			"Ram, 31, 90000", 
			"Shyam, 34, 125000"
			})
	void parameterCsvTest(String personName, int age, float salary) {
		System.out.println(personName + " = " + age + " : " + salary);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/sample.csv", numLinesToSkip = 1)
	void parameterCsvFromFileTest(String personName, int age, int salary) {
		System.out.println(personName + " = " + age + " : " + salary);
	}
}
