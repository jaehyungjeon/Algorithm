package Level1.HarshadNum;

import java.util.*;

/*
 * Question : 
	양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 
	예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
	자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
 * 
 * 	Solution : 1. 자릿수 만큼 for문을 돌려서 값들을 정수형 타입으로 변환하여 나눌 수의 총값을 구한다.
 * 			   2. 들어온 수 / 총 값이 0이 아닐 경우, false를 return한다.
 *  
 * */

public class Solution {
	
    public boolean solution(int x) {
        boolean answer = true;

        int count = 0;
        String str = String.valueOf(x);
        for(int i=0; i<str.length(); i++) {
        	count += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        
        if(x%count != 0) answer = false;
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int x = 919;
		System.out.println(sol.solution(x));
	}
}
