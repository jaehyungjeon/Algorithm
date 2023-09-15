package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : In a lot of places in the world, elite universities come in pairs and their students like to challenge each other every year. 
	In England, Oxford and Cambridge are famous for The Boat Race, an annual rowing race that opposes them. 
	In Switzerland, students from Zürich and Lausanne battle in a famous annual ski challenge.

	TelecomParisTech and Eurecom, two famous French schools, are also planning to organize a multi-sport tournament. 
	They have already agreed on the choice of sports and the rules of the game, but the only point of disagreement is on where the contest should be hosted. 
	Indeed, every school has been bragging for years about the wonderful sport facilities that they have.

	At last, it was agreed that the competition would be hosted at the school which has the larger rectangular sports field. 
	The only thing left is to determine which school this is: given the size of the fields, determine which school has the field with the larger surface.
	
	input			 
	2
	3 2 4 2
	536874368 268792221 598 1204
	
	output
	Eurecom
	TelecomParisTech
	
	Solution : 1. 넓이 비교
	
*/

public class BaekJoon_16099 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Long lv = Long.parseLong(st.nextToken());
			Long wv = Long.parseLong(st.nextToken());
			
			Long le = Long.parseLong(st.nextToken());
			Long we = Long.parseLong(st.nextToken());
			
			if(lv * wv == le * we) {
				System.out.println("Tie");
			} else if(lv * wv > le * we) {
				System.out.println("TelecomParisTech");
			} else {
				System.out.println("Eurecom");
			}
		}
	}

}
