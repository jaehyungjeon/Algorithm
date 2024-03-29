package Level1.ClapWaterMelon;

import java.util.*;

/*
 * Question : 
	길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 
	예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
 * 
 * 	Solution : 1. 2로 나눠서 나머지 0 : 수 / 1 : 박
 *  
 * */

public class Solution {
	
    public String solution(int n) {
        String answer = "";
        
        for(int i=0; i<n; i++) {
        	if(i%2 == 0) {
        		answer += "수";
        	} else {
        		answer += "박";
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 3;
		System.out.println(sol.solution(n));
	}
}
