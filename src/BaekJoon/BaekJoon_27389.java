package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : A Metronome is a mechanical device used by musicians for keeping time. 
	It is a very clever device, based on a spring, an inverted pendulum, and an escapement gear. 
	Milo is learning to play the glockenspiel, and has purchased a metronome to help him keep time. 
	Milo has noticed that for every complete turn (one revolution) of the key, the metronome will give four ticks. 
	Milo wants the metronome to stop at the end of each song that he tries to play.

	For a given song, how many revolutions must he wind the key?

	input			 
	16
	
	output
	4.0
	
	Solution : 1. 4로 나누면 됨.
	
*/

public class BaekJoon_27389 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Double N = Double.parseDouble(br.readLine());
		
		System.out.println(N / 4);
	}

}
