package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : Робинзон Крузо на необитаемом острове отмечает дни стене своей хижины.
	Каждый день он ставит зарубку, которую будем обозначать английской буквой <<I>>, а раз в 5 дней зачеркивает четыре предыдущие зарубки, получая символ, 
	который мы обозначим как <<V>>.
	
	Какая запись получится на стене хижины Робинзона на 
	$n$-й день?


	input			 
	13
	
	output
	VVIII
	
	Solution : 1. 몫과 나머지로 구성
	
*/

public class BaekJoon_27219 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int mo = N/5;
		int re = N%5;
		
		for(int i=0; i<mo; i++) {
			System.out.print("V");
		}
		
		for(int i=0; i<re; i++){
			System.out.print("I");
		}
		
	}

}
