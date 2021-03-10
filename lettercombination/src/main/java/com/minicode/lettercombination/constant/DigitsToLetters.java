package com.minicode.lettercombination.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DigitsToLetters {

	/**
	 * convert digits to Letters
	 */
	public static Map<String, List<String>> digitsMap = new HashMap<String, List<String>>(){
		{
			put("0", Arrays.asList(""));
			put("1", Arrays.asList(""));
			put("2", Arrays.asList("a","b","c"));
			put("3", Arrays.asList("d","e","f"));
			put("4", Arrays.asList("g","h","i"));
			put("5", Arrays.asList("j","k","l"));
			put("6", Arrays.asList("m","n","o"));
			put("7", Arrays.asList("p","q","r","s"));
			put("8", Arrays.asList("t","u","v"));
			put("9", Arrays.asList("w","x","y","z"));
		}
	};
}
