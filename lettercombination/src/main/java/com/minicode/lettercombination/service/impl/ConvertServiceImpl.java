package com.minicode.lettercombination.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.minicode.lettercombination.constant.DigitsToLetters;
import com.minicode.lettercombination.service.ConvertService;

@Service
public class ConvertServiceImpl implements ConvertService {
	
	//Enter a numeric regular expression
	public final static String DIGITIS_REG = "[0-9]{1,2}";

	/* *
	 * Convert an input number into a random combination of letters
	 */
	public String convertDigitsToLetters(String input) {
		if (StringUtils.isEmpty(input)) {
			//the input number is null,so return null
			return null;
		}
		String[] inputDigits = input.split("");
		//Convert a number into an array of letters
		List<String[]> letterList = getLetterList(inputDigits);
		List<String[]> result = new ArrayList<String[]>();
		result =letterCombination(0,letterList,result);
		StringBuilder output = new StringBuilder();
		for (String[] letters : result) {
			StringBuilder sb = new StringBuilder();
			//Put the letters together and output them
			for (String letter : letters) {
				sb.append(letter);
			}
			output.append(sb+" ");
		}
		return output.toString();
	}

	/**
	 * Recursive Method,Complete the random combination of letters
	 * @param index
	 * @param letterList
	 * @param result
	 * @return
	 */
	private List<String[]> letterCombination(int index, List<String[]> letterList, List<String[]> result) {
		if (index==letterList.size()) {
			return result;
		}
		List<String[]> resultCombination = new ArrayList<String[]>();
		String[] letters = letterList.get(index);
		if (0==index) {
			//The first array is put directly into the result set
			for (String string : letters) {
				resultCombination.add(new String[]{string});
			}
		}else {
			//First traverse the existing letter array
			for (String[] letterArray : result) {
				int length = letterArray.length;
				//Then traverse the current alphabet array, splice to form a new alphabet array and put it into the result
				for (String dt : letters) {
					//create A new array with a length greater than 1 will hold this letter
					String[] dest = new String[letterArray.length+1];
					//Copy original array
					System.arraycopy(letterArray, 0, dest, 0, length);
					//Add this letter to the new array
					dest[dest.length-1]=dt;
					//Put it in the results
					resultCombination.add(dest);
				}
			}
		}
		//The recursive call itself continues to combine letters randomly
		return letterCombination(index+1,letterList,resultCombination);
	}

	/**
	 * Convert a number into an array of letters
	 * @param inputDigits
	 * @return
	 */
	private List<String[]> getLetterList(String[] inputDigits) {
		Map<String, List<String>> digitsmap = DigitsToLetters.digitsMap;
		List<String[]> result = new ArrayList<String[]>();
		for(int i=0;i<inputDigits.length;i++){
			//The numbers 0 and 1 have no corresponding letters,Exclude numbers of 0 and 1 
			if (!"01".contains(inputDigits[i])) {
				List<String> letters = digitsmap.get(inputDigits[i]);
				String[] letterArray =(String[])letters.toArray();
				//Add the obtained letter array to the collection
				result.add(letterArray);
			}
		}
		return result;
	}

	/* 
	 * Determine whether the input number meets the conditions
	 * 
	 */
	public boolean macthCondition(String input) {
		if (StringUtils.isEmpty(input)) {
			return false;
		}
		//Using regular expression to judge whether the input number meets the condition
		if (!input.matches(DIGITIS_REG)) {
			return false;
		}
		return true;
	}
	
	

}
