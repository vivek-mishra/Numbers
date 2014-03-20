package com.sample.test;

import static com.sample.utils.NumbersUtil.getDivisor;
import static com.sample.utils.NumbersUtil.unitsMap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sample.utils.NumbersUtil;

public class Numbers
{
	private static Logger log = Logger.getLogger("Numbers");
		

	public static List<String> breakNumber(List<String> queue, String number, int divisor){
		if (number.length() == 1){
			return NumbersUtil.processUnits(queue, number);
		}
		if(number.length() == 2){
			return NumbersUtil.processTens(queue, number);
		}
		log.log(Level.INFO, "looking up for "+(Integer.parseInt(number)/divisor));

		queue.add(NumbersUtil.processHundreds(Integer.parseInt(number)/divisor+""));
		queue.add(unitsMap.get(divisor+""));
		
		log.log(Level.INFO, "breaking number "+number);
		
		return breakNumber(queue, Integer.parseInt(number)%divisor+"",Integer.parseInt(getDivisor(Integer.parseInt(number)%divisor+"")+""));
	}
	
	public static void main(String[] args)
	{
		List<String> queue = new LinkedList<String>();
		//int number = 1760098;
		int number = 8;
		String strNumber = number+"";
		if(NumbersUtil.isValidNumber(strNumber)){
			StringBuilder numBuilder = new StringBuilder();
			breakNumber(queue, strNumber, getDivisor(strNumber));
			log.log(Level.INFO,"TEXTUAL REPRESENTATION ::"+number+" --> "+queue);
		
			String last = queue.get(queue.size()-1);
			if(last!=null && last.equalsIgnoreCase("zero")){
				queue.remove(last);
			}
			Iterator<String> iter = queue.iterator();

			log.log(Level.INFO, last);
			while(iter.hasNext()){
				numBuilder.append(" ").append(iter.next()).append(" ");
			}
		
			log.log(Level.INFO,"TEXTUAL REPRESENTATION ::"+number+" --> "+numBuilder);
		}
		else{
			log.log(Level.WARNING, "SUPPLIED NUMBER IS INVALID! "+strNumber);
		}
	}
}
