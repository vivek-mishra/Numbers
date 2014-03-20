package com.sample.tests;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class NumbersTestRunner {
	public static void main(String[] args) {
		Logger log = Logger.getLogger("NumbersTestRunner");
		Result result = JUnitCore.runClasses(NumbersTest.class);
		for (Failure failure : result.getFailures()) {
			log.log(Level.WARNING,"Failure:: "+failure.toString());
		}
	}

}
