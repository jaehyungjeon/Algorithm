package Level1.NaturalNumBackArray;

import java.util.*;

/*
 * Question : 
	자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
	예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 * 
 * 	Solution : 1. 배열을 역순으로 담아주고
 * 			   2. Arrays 유틸을 이용하여 int로 변환하면서 배열에 때려넣는 방식
 * 			   3. 주석처리된 부분은 내가 원하던 바를 이룬 코딩형식
 *  
 * */

public class Solution {
	
    public int[] solution(long n) {
        int[] answer = {};
        String[] arr = String.valueOf(n).split("");
        
        String[] reverseArr = new String[arr.length];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) { 
        	reverseArr[j] = arr[i]; 
    	}
        
        answer = Arrays.stream(reverseArr).mapToInt(Integer::parseInt).toArray();
        return answer;

        
        /* 내가 원했던 느낌 */
//        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	long n = 11234;
		System.out.println(sol.solution(n));
	}
}
