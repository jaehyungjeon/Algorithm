package FindDecimal;

import java.util.*;

/*
 * Question : 
	1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
	
	소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
	(1은 소수가 아닙니다.)
 * 
 * 	Solution : 1. 소수를 구할 때, 0, 1은 소수가 아니므로 0으로 셋팅
 * 			   2. 제곱근 만큼 for문을 돌리고 안쪽에서 다시금 i의 배수만큼 돌려 존재하면 0으로 배열 셋팅
 * 			   3. 최종 결괏값 중 배열에 0이 들어가지 않은 것의 갯수 만큼 ++
 *  
 * */

public class Solution {
	
    public int solution(int n) {
	   int answer = 0;
       
	   int[] arr = new int[n+1];
	   arr[0] = arr[1] = 0;
	   
	   for(int i=2; i<=n; i++) {
		   arr[i] = i;
	   }
	   
	   for(int i=2; i<=(int)Math.sqrt(n); i++) {
		   if(arr[i] == 0) continue;
		   for(int j=2*i; j<=n; j+=i) {
			   arr[j] = 0;
		   }
	   }
	   
	   for(int i=0; i<arr.length; i++) {
		   if(arr[i] != 0) answer++;
	   }
       return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 10;
		System.out.println(sol.solution(n));
	}
}
