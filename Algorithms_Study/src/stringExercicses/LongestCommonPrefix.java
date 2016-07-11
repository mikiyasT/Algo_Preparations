package stringExercicses;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		
		String[] strArray = new String[]{"babdul","babdis","badbrhama","babas"};
		
		System.out.println("Testing out the function");
		String shortest = findShortest(strArray);
		System.out.println("Shortest " + shortest);
		String longestPrefix = findLongestPrefix(strArray,shortest);
		System.out.println(" longest prefix is -> " + longestPrefix);
		

	}
	public static String findShortest(String[] strArray){
		
		String shortest = "";
		int min_len = 1000; // assuming all strings can not be larger than 1000 chars;
		for(int i = 0; i <strArray.length; i++){
			if(strArray[i].length() < min_len){
				shortest = strArray[i];
				min_len = strArray[i].length();
			}
		}
		return shortest;
	}
	
	public static String findLongestPrefix(String[] strArray, String shortest){
		//return "Molla";
		String prefix = "";
		boolean longest_found = false;
		int longest_index = 0;
		
		for(int j = shortest.length() - 1; j >=0; j--){
			//longest_found = true;
			
			System.out.println("Starting to compare lower substrting");
			
			if(!longest_found)
			{
				longest_index = j;
				for(int i = 0; i <strArray.length; i++){
					System.out.println("Longest_Index " + longest_index + "at " + i); 
					String arrayElementSubstr = strArray[i].substring(0, longest_index+1);
					String shortestElemSubstr = shortest.substring(0, longest_index+1);
					System.out.println(
							strArray[i] + " ->" + arrayElementSubstr + "->" + shortestElemSubstr);
					
					boolean same = arrayElementSubstr.equals(shortestElemSubstr);
					System.out.println(" Are same - " + same);
					if(!same)
					{
						
						longest_index = 0;
						break;
					}
					if(i == strArray.length - 1)
						longest_found = true;
					
					
				}
		}
			
			
		}
		prefix = shortest.substring(0,longest_index+1);
		return  prefix;
	}

}
