package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : Макс и Мел --- заядлые киноманы. Они оба посмотрели все топ-100 фильмов по версиям большинства популярных сайтов, 
	могут перечислить фильмографию любого известного актера, и редкий их диалог не заканчивается спором, стрелял ли Хан Соло первым.
	
	Одним прекрасным октябрьским утром Макс и Мел решили выяснить, кто же из них больше времени уделяет своему хобби. Макс подсчитал, 
	что за последний год он посмотрел 
	$t_1$ трейлеров, 
	$e_1$ сериалов и 
	$f_1$ фильмов. Мел же посмотрел 
	$t_2$ трейлеров, 
	$e_2$ сериалов, 
	$f_2$ фильмов. Каждый трейлер идет три минуты, сериал 20 минут, а фильм два часа. Помогите им разрешить спор и определить, 
	кто же за последний год посмотрел больше минут видео.

	input			 
	15 1 3
	1 3 3
	
	output
	Max
	
	Solution : 1. 3 / 20 / 120
	
*/

public class BaekJoon_28927 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int maxSum = 0;
		int t1 = Integer.parseInt(st.nextToken());
		int e1 = Integer.parseInt(st.nextToken());
		int f1 = Integer.parseInt(st.nextToken());
		maxSum = (t1 * 3) + (e1 * 20) + (f1 * 120);
		
		st = new StringTokenizer(br.readLine());
		int melSum = 0;
		int t2 = Integer.parseInt(st.nextToken());
		int e2 = Integer.parseInt(st.nextToken());
		int f2 = Integer.parseInt(st.nextToken());
		melSum = (t2 * 3) + (e2 * 20) + (f2 * 120);
		
		if(maxSum > melSum) {
			System.out.println("Max");
		} else if(maxSum == melSum) {
			System.out.println("Draw");
		} else {
			System.out.println("Mel");
		}
	}

}
