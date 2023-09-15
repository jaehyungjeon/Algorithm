package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
	Question : Учителката по математика дала на учениците да намерят неизвестното x от равенството: a·x = b-c. 
	Числата а, b и c са естествени числа и са такива, че решението x е цяло число. 
	Знайко посещавал школата по информатика и опитал да направи програма, но се затруднил. 
	Помогнете му, като напишете програма equation, която намира неизвестното x.

	input			 
	4
	20
	8
	
	output
	3
	
	Solution : 1. a * x = b - c
	
*/

public class BaekJoon_24309 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger A = new BigInteger(br.readLine());
		BigInteger B = new BigInteger(br.readLine());
		BigInteger C = new BigInteger(br.readLine());
		
		System.out.println(B.subtract(C).divide(A));
	}

}
