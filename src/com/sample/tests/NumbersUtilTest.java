package com.sample.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sample.utils.NumbersUtil;

public class NumbersUtilTest {

	@Test
	public void TestMethods(){
		assertEquals("Result", 1000, NumbersUtil.getDivisor(9911+""));
		assertEquals("Result", 100, NumbersUtil.getDivisor(991+""));
		assertTrue(NumbersUtil.isValidNumber(9+""));
	}
	@Test
	public void testTens(){
		List<String> stack = new ArrayList<String>();
		stack.add("one");
		stack.add("hundred");
		assertEquals("Result","[one, hundred,  and , eleven]",(NumbersUtil.processTens(stack, 11+"")).toString());
	}
	@Test
	public void testUnits(){
		List<String> stack = new ArrayList<String>();
		stack.add("one");
		stack.add("hundred");
		assertEquals("Result","[one, hundred,  and , seven]",(NumbersUtil.processUnits(stack, 7+"")).toString());
	}
	@Test
	public void testHundreds(){
		assertEquals("Result","one",(NumbersUtil.processHundreds(1+"")).toString());
	}
}
