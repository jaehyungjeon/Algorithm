package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : Arno wants to arrive at school before the start of classes. He sets an alarm clock to ring in the morning. 
	Now he's curious how many hours of sleep he will get. Write a program that would calculate the length of Arno's sleep time.

	input			 
	23
	7
	
	output
	8
	
	Solution : 1. 20 ~ 23 => 24 - N || 0 ~ 3 => N
	
*/

public class BaekJoon_29863 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Hour = Integer.parseInt(br.readLine());
		int Alarm = Integer.parseInt(br.readLine());
		if(Hour >= 20 && Hour <= 23) {
			Hour = 24 - Hour;
			System.out.println(Alarm + Hour);
		} else {
			System.out.println(Alarm - Hour);
		}
	}

}
