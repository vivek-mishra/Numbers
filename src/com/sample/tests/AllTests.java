package com.sample.tests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sample.tests.NumbersTest;


@RunWith(Suite.class)
@SuiteClasses({NumbersTest.class,NumbersUtilTest.class})
public class AllTests {

}
