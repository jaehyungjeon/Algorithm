package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : 오늘은 2007년 1월 1일 월요일이다. 그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램을 작성하시오.
	
	input			 
	3 14
	
	output
	WED
	
	Solution : 1. 일수의 합을 구한 뒤 7로 나눈 나머지를 요일로 지정한다.
	 		   2. 리스트로 구현하여 뽑았다.
	
*/

public class BaekJoon_1924 {

	public static List<Integer> thrityOne = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
	public static List<Integer> thrity = Arrays.asList(4, 6, 9, 11);
	public static List<String> days = Arrays.asList("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		int sum = 0;
		
		for(int i=1; i<month; i++) {
			if(thrityOne.contains(i)) {
				sum += 31;
			} else if(thrity.contains(i)) {
				sum += 30;
			} else {
				sum += 28;
			}
		}
		
		sum += day;
		
		System.out.println(days.get(sum % 7));
	}

}
