package com.sample.junitsample.greeting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GreetingTest implements GreetingTests{

	Greeting greeting;
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("Before All...");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before Each...");
		
		greeting = new Greeting();
	}

	@Test
	void testHelloWorld() {
		System.out.println(greeting.helloWorld());
	}

	@Test
	void testHelloWorld1() {
		System.out.println(greeting.helloWorld("Subham"));
	}
	
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Each...");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("After All...");
	}

}
