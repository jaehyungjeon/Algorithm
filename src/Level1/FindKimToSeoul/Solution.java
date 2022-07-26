package FindKimToSeoul;

import java.util.*;

/*
 * Question : 
	String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요. 
	seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
 * 
 * 	Solution : 1. 인덱스 찾아서 리턴
 *  
 * */

public class Solution {

    public String solution(String[] seoul) {
        String answer = "";
        
        int count = 0;
        for(int i=0; i<seoul.length; i++) {
        	if(seoul[i].equals("Kim")) {
        		count = i;
        		break;
        	}
        }
        
        answer = "김서방은 " + count + "에 있다";
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String[] seoul = {"Jane", "Kim"};
		System.out.println(sol.solution(seoul));
	}
}
