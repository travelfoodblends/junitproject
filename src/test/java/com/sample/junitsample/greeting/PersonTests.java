package com.sample.junitsample.greeting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("Person")
public interface PersonTests {

//	@BeforeEach
//	default void beforeEachTest(TestInfo testInfo, RepetitionInfo repeatInfo) {
//		System.out.println(testInfo.getDisplayName() + " : " + repeatInfo.getCurrentRepetition());
//	}
}
