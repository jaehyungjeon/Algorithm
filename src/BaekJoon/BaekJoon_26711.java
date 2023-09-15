package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
	Question : Mamy dla was zadanie stare jak świat, ale w nieco odświeżonej wersji. 
	Polega ono na dodaniu do siebie dwóch liczb, które tym razem mogą być dość duże. 
	Gdyby tylko na Potyczkach Algorytmicznych było jakieś narzędzie, które pomaga radzić sobie z dużymi liczbami...

	input			 
	1997
	25
	
	output
	2022
	
	Solution : 1. A + B
			   2. BigInteger 사용.
	
*/

public class BaekJoon_26711 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger A = new BigInteger(br.readLine());
		BigInteger B = new BigInteger(br.readLine());
		
		System.out.println(A.add(B));
	}

}
