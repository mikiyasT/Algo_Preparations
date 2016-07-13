package LongestMergedString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LongestMergedString {

	public static void main(String[] args) {
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("RBR");
		stringList.add("BBR");
		stringList.add("RRB");
		stringList.add("SRS");
		//System.out.println("Original word list " + );
		
		for(int i = 0; i < stringList.size(); i++){
			String anchor = stringList.get(i);
			
			for(int j = 0; j < stringList.size(); j++){
				String check = stringList.get(j);
				if(i != j){
					if(anchor.charAt(anchor.length()-1) == check.charAt(0)){
						stringList.set(i, anchor + "_"+check);
						stringList.remove(j);
						anchor = stringList.get(i);
						j = 0;
					}
					else if(anchor.charAt(0) == check.charAt(check.length()-1)){
						stringList.set(i, check + "_"+anchor);
						stringList.remove(j);
						anchor = stringList.get(i);
						j = 0;
						
					}
				}
				
			}
		}
		//other things to consider in the above for loop,
		//if no string are merged and three is any other left over string that is greater than the achnor, swap it..
		System.out.println("The combined word is " + stringList.get(0) + " Size " + stringList.size());
		
		HashMap<Integer,Integer> digitOcc = new HashMap<Integer,Integer>();
		digitOcc.put(0, 5);
		digitOcc.put(1, 4);
		digitOcc.put(2, 3);
		digitOcc.put(3, 3);
		
		//find the key with the highest value

	}

}
