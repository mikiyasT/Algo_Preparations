package stringExercicses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringScrathcWorks {

	public static void main(String[] args) {
		String s = "the sky is blue";
		char s_char[] = s.toCharArray();
		List<Character> char_list = new ArrayList<Character>();
		for(char c:s_char){
			char_list.add(c);
		}
		System.out.println("Started ");
		char_list.stream().forEach(c->System.out.println(c));
		
		String str_array[] = s.split(" ");
		String rev_str = ""; 
		for(int i = str_array.length - 1; i >= 0 ; i--){
			rev_str += str_array[i] + " ";
			
		}
		System.out.println(" new reve " + rev_str);
		
		//Remove duplicate words from the given phrase
		String s2 = "hey you hey me hey there";
		String[] str_array2 = s2.split(" ");
		
		List<String> wordList = new ArrayList<String>();
		wordList = Arrays.asList(str_array2);
		wordList.stream().sorted().map(str->str+"->").distinct().forEach(System.out::print);
		
		System.out.println(" ");
		
		//Remove duplicate chars from the given word
		String word = "mississipi";
		char[] word_chars = word.toCharArray();
		Character[] word_characters = new Character[word.length()];
		int i = 0;
		for(char c:word_chars)
			word_characters[i++] = new Character(c);
		
		List<Character> charList = new ArrayList<Character>();
		charList = Arrays.asList(word_characters);
		charList.stream().distinct().forEach(System.out::print);

	}

}
