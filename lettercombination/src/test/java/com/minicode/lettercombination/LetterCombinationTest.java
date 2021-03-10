package com.minicode.lettercombination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.minicode.lettercombination.service.ConvertService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LetterCombinationTest {
	
	private final static Logger logger = LoggerFactory.getLogger(LetterCombinationTest.class);

	@Autowired
	ConvertService convertService;
	
	@Test
	public void demandFirst(){
		String input = "123";
		String convertDigitsToLetters = convertService.convertDigitsToLetters(input);
		logger.info("output:",convertDigitsToLetters);
	}
	
	@Test
	public void demandSecond(){
		String input = "456";
		String output = "";
		if (!convertService.macthCondition(input)) {
			//If the input number does not meet the condition, output prompt
			output = "Illegal input! Only 0-99 numbers can be entered. Please re-enter：";
		}else {
			output = convertService.convertDigitsToLetters(input);
		}
		logger.info("ooutput:"+output);
	}
}
