package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : Informatycy to też ludzie, więc jak wszyscy potrzebują trochę miłości. 
	Bajtek właśnie postanowił wyznać miłość pięknej Bajtolinie i w tym celu zamierza narysować jej N serduszek w ASCII art złożonych ze znaków małpy (@).

	Jedno serduszko wygląda następująco:
	
	 @@@   @@@ 
	@   @ @   @
	@    @    @
	@         @
	 @       @ 
	  @     @  
	   @   @   
	    @ @    
	     @     
	Bajtek chciałby, żeby serduszka były wypisane jedno pod drugim. Pomóż mu!
	
	Napisz program, który: wczyta liczbę N – liczbę serduszek, które Bajtek chce narysować Bajtolinie i wypisze na standardowe wyjście N serduszek w 
	formacie opisanym powyżej.
	
	input			 
	2
	
	output
	 @@@   @@@ 
	@   @ @   @
	@    @    @
	@         @
	 @       @ 
	  @     @  
	   @   @   
	    @ @    
	     @     
	 @@@   @@@ 
	@   @ @   @
	@    @    @
	@         @
	 @       @ 
	  @     @  
	   @   @   
	    @ @    
	     @     
	
	Solution : 1. 반복문..
	
*/

public class BaekJoon_26766 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			heart();
		}
	}
	
	private static void heart() {
		System.out.println(" @@@   @@@ ");
		System.out.println("@   @ @   @");
		System.out.println("@    @    @");
		System.out.println("@         @");
		System.out.println(" @       @ ");
		System.out.println("  @     @  ");
		System.out.println("   @   @   ");
		System.out.println("    @ @    ");
		System.out.println("     @     ");
	}
}
