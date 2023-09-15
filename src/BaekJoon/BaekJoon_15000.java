package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : Earth is under attack! Messages need to be sent to the Earth Defense Force (EDF) that makes clear that the situation is dire. 
	The EDF’s strongest forces consist of mechs (huge bipedal robots) that are piloted by Japanese teenagers. 
	To make sure that the messages come across as urgent, they must be displayed on the monitors of the pilots in uppercase letters. 
	Unfortunately, the tachyon communication system that is used by the EDF is only able to send strings in lower-case alphabetic characters.

	The set of lower-case alphabetic characters is made up of the following characters: 
	’a’, ’b’, ’c’, ’d’, ’e’, ’f’, ’g’, ’h’, ’i’, ’j’, ’k’, ’l’, ’m’, ’n’, ’o’, ’p’, ’q’, ’r’, ’s’, ’t’, ’u’, ’v’, ’w’, ’x’, ’y’, ’z’.
	
	Your job is to write a program that converts the given messages to upper-case.

	input			 
	alert
	
	output
	ALERT
	
	Solution : 1. 대문자변환
	
*/

public class BaekJoon_15000 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(br.readLine().toUpperCase());
	}

}
