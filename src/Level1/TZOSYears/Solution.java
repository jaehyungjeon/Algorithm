package Level1.TZOSYears;

import java.util.*;

/*
 * Question : 
	2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 
	두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT
	입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
 * 
 * 	Solution : 1. 1, 3, 5, 7 / 8, 10, 12 -> 31
 * 			   2. 4, 6, 9, 11 -> 30
 * 			   3. 2 -> 29
 * 
 * */

public class Solution {

    public String solution(int a, int b) {
        String answer = "";
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int count = 0;
        for(int i=0; i<a-1; i++) {
        	count += day[i];
        }
        
        count += b-1;
        
        answer = days[count % 7];
        		
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int a = 5;
    	int b = 24;
		System.out.println(sol.solution(a, b));
	}
}
