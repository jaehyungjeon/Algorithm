package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : Spies Breaching Computers (SBC) is a private digital spy agency that is developing a new device for intercepting information using electromagnetic waves, which allows spying even without physical contact with the target.

	The device tries to collect information one byte at a time, this is, a sequence of 
	$8$ bits where each of them, naturally, can have a value of 
	$0$ or 
	$1$. In certain situations, due to interference from other devices, the reading cannot be done successfully. In this case, the device returns the value 
	$9$ for the corresponding bit, informing that the reading could not be performed.
	
	In order to automate the recognition of the information the device reads, a request was made for a program that, based on the information read by the device, informs whether all bits were read successfully or not. Your task is to write this program.
	
	input			 
	0 0 1 1 0 1 0 1
	
	output
	S
	
	Solution : 1. 9 나오면 "F"
	
*/

public class BaekJoon_26209 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<8; i++) {
			if(st.nextToken().equals("9")) {
				System.out.println("F");
				
				System.exit(0);
			}
		}
		
		System.out.println("S");
	}

}
