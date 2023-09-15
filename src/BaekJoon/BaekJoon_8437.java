package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
	Question : Julka zaskoczyła wczoraj w przedszkolu swoją wychowawczynię rozwiązując następującą zagadkę:

	Klaudia i Natalia mają razem 10 jabłek, ale Klaudia ma o 2 jabłka więcej niż Natalia. Ile jabłek ma każda z dziewczynek?
	Julka odpowiedziała bez namysłu: Klaudia ma sześć jabłek, natomiast Natalia ma cztery jabłka.
	
	Wychowywaczyni postanowiła sprawdzić, czy odpowiedź Julki nie była przypadkowa i powtarzała zagadkę, 
	za każdym razem zwiększając liczby jabłek w zadaniu. Julka zawsze odpowiadała prawidłowo. Zaskoczona wychowawczyni chciała kontynuować ,,badanie'' Julki, ale przy bardzo dużych liczbach sama nie potrafiła szybko rozwiązać zagadki. Pomóż pani przedszkolance i napisz program, który będzie podpowiadał jej rozwiązania.
	
	Napisz program, który:
	
	wczyta (ze standardowego wejścia) liczbę jabłek, które mają razem obie dziewczynki oraz o ile więcej jabłek ma Klaudia,
	obliczy, ile jabłek ma Klaudia i ile jabłek ma Natalia,
	wypisze wynik (na standardowe wyjście).
	
	input			 
	10
	2
	
	output
	6
	4
	
	Solution : 1. (N - M) / 2 || (N - M) /2 + M
			   2. int -> BigInteger

*/

public class BaekJoon_8437 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(br.readLine());
		BigInteger M = new BigInteger(br.readLine());
		
		System.out.println(N.subtract(M).divide(new BigInteger("2")).add(M));
		System.out.println(N.subtract(M).divide(new BigInteger("2")));
	}

}
