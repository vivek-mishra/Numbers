package com.sample.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sample.constants.NumberConstants;

public class NumbersUtil
{
	private static Logger log = Logger.getLogger("NumbersUtil");
	
	
	private static Map<String, String> lookup = new HashMap<String, String>();
	private static Map<String,String> divisorMap = new HashMap<String, String>();
	public static Map<String, String> unitsMap = new HashMap<String, String>();
	
	static{
		lookup.put("0", "zero");
		lookup.put("1", "one");
		lookup.put("2", "two");
		lookup.put("3", "three");
		lookup.put("4", "four");
		lookup.put("5", "five");
		lookup.put("6", "six");
		lookup.put("7", "seven");
		lookup.put("8", "eight");
		lookup.put("9", "nine");
		lookup.put("10", "ten");
		lookup.put("11", "eleven");
		lookup.put("12", "twelve");
		lookup.put("13", "thirteen");
		lookup.put("14", "fourteen");
		lookup.put("15", "fifteen");
		lookup.put("16", "sixteen");
		lookup.put("17", "seventeen");
		lookup.put("18", "eightteen");
		lookup.put("19", "ninteen");
		lookup.put("20", "twenty");
		lookup.put("30", "thirty");
		lookup.put("40", "forty");
		lookup.put("50", "fifty");
		lookup.put("60", "sixty");
		lookup.put("70", "seventy");
		lookup.put("80", "eighty");
		lookup.put("90", "ninty");
		
		unitsMap.put("10", "ten");
		unitsMap.put("100", "hundred");
		unitsMap.put("1000", "thousand");
		unitsMap.put("1000000", "million");
		unitsMap.put("1000000000", "billion");
		
		divisorMap.put("1", "1");
		divisorMap.put("2", "10");
		divisorMap.put("3", "100");
		divisorMap.put("4", "1000");
		divisorMap.put("5", "1000");
		divisorMap.put("6", "1000");
		divisorMap.put("7", "1000000");
		divisorMap.put("8", "1000000");
		divisorMap.put("9", "1000000");
		divisorMap.put("10", "1000000000");
		divisorMap.put("11", "1000000000");
		divisorMap.put("12", "1000000000");
	}	

	public static boolean isValidNumber(String number){
		if(number != null && number.trim().length() >0){
			if((number!=null && number.matches("\\d{0,9}") && (Integer.parseInt(number) > 0 && Integer.parseInt(number) < NumberConstants.MAX_NUMBER)))
				return true;
		}
		
		return false;
	}
	
	public static int getDivisor(String number){
		log.log(Level.INFO,"DIVISOR input number "+number);
		int divisor = 1;
		if(Integer.parseInt(number)>0){
			divisor = Integer.parseInt(divisorMap.get(number.trim().length()+""));
			log.log(Level.INFO," Returning divisor "+divisor);
		}
		return divisor;
	}

	public static List<String> processUnits(List<String> stack, String number){
		if(stack!=null && stack.size()>0 && Integer.parseInt(number) != 0){
		stack.add(NumberConstants.AND);
		}
		if(/*Integer.parseInt(number) != 0 &&*/ Integer.parseInt(number) < 10){
		stack.add(lookup.get(Integer.parseInt(number)+""));
		}
		return stack;
	}
	
	public static List<String> processTens(List<String> stack, String number){
		if(stack!=null && stack.size()>0)
		stack.add(NumberConstants.AND);
		if(Integer.parseInt(number) < 21){ // deal with the simple teens
			stack.add(lookup.get(Integer.parseInt(number)+""));
		}
		else{
			stack.add(lookup.get((Integer.parseInt(number)/10 * 10)+""));
			stack.add(lookup.get((Integer.parseInt(number)%10+"")));
		}
		return stack;
	}
	
	public static String processHundreds(String number){
		log.log(Level.INFO, "TEXT NUMBER ---> "+number);
		StringBuilder sbldr = new StringBuilder();
		if(lookup.get(number) == null && number.length() == 2){
			sbldr.append(lookup.get((Integer.parseInt(number)/10 * 10)+""));
			sbldr.append(lookup.get(Integer.parseInt(number)%10+"")).toString();
		}
		else if(number.length() == 3){
			sbldr.append(lookup.get((Integer.parseInt(number)/100)+"")).append(" hundred ");
			int tens = Integer.parseInt(number)%100;
			if(tens > 0 && tens <= 20){
				sbldr.append(NumberConstants.AND);
				sbldr.append(lookup.get(Integer.parseInt(number)%100+""));
			}
			else if(tens > 20){
				sbldr.append(NumberConstants.AND);
				sbldr.append(lookup.get(((Integer.parseInt(number)%100)/10 * 10)+""));
				sbldr.append(lookup.get(Integer.parseInt(number)%10+"")).toString();
			}
		}
		else{
			sbldr.append(lookup.get(number));
		}
		log.log(Level.INFO, "RETURNING ==> "+sbldr.toString());

		return sbldr.toString();
	}

}
