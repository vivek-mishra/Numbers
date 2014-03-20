package com.sample.tests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.logging.Logger;

import org.junit.Test;

import com.sample.test.Numbers;
import com.sample.utils.NumbersUtil;

public class NumbersTest {
	Logger log = Logger.getLogger("NumberTest");
	@Test
	public void testNumbers(){
		int number = 991;
		int diffNumber = 9911;
		int unitThousand = 4334;
		int tensThousand = 50789;
		int hundredsThousand = 652374;
		int unitMillions = 7634507;
		int unitMillionsUnit = 8000001;
		int unitMillionsThousandsUnit = 8000101;
		String strNumber = number+"";
		String strDiffNumber = diffNumber+"";
		assertEquals("Result","[nine, hundred,  and , ninty, one]",(Numbers.breakNumber(new LinkedList<String>(), strNumber, NumbersUtil.getDivisor(strNumber))).toString());
		assertEquals("Result","[nine, thousand, nine, hundred,  and , eleven]",(Numbers.breakNumber(new LinkedList<String>(), strDiffNumber, NumbersUtil.getDivisor(strDiffNumber))).toString());
		assertEquals("Result","[four, thousand, three, hundred,  and , thirty, four]",(Numbers.breakNumber(new LinkedList<String>(), unitThousand+"", NumbersUtil.getDivisor(strDiffNumber))).toString());
		assertEquals("Result","[fifty, thousand, seven, hundred,  and , eighty, nine]",(Numbers.breakNumber(new LinkedList<String>(), tensThousand+"", NumbersUtil.getDivisor(tensThousand+""))).toString());
		assertEquals("Result","[six hundred  and fiftytwo, thousand, three, hundred,  and , seventy, four]",(Numbers.breakNumber(new LinkedList<String>(), hundredsThousand+"", NumbersUtil.getDivisor(hundredsThousand+""))).toString());
		assertEquals("Result","[seven, million, six hundred  and thirtyfour, thousand, five, hundred,  and , seven]",(Numbers.breakNumber(new LinkedList<String>(), unitMillions+"", NumbersUtil.getDivisor(unitMillions+""))).toString());
		assertEquals("Result","[eight, million,  and , one]",(Numbers.breakNumber(new LinkedList<String>(), unitMillionsUnit+"", NumbersUtil.getDivisor(unitMillionsUnit+""))).toString());
		assertEquals("Result","[eight, million, one, hundred,  and , one]",(Numbers.breakNumber(new LinkedList<String>(), unitMillionsThousandsUnit+"", NumbersUtil.getDivisor(unitMillionsThousandsUnit+""))).toString());
	
	}

	}

