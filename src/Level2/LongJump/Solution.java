package Level2.LongJump;

import java.util.*;

/*
 * Question : 
	효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
	(1칸, 1칸, 1칸, 1칸)
	(1칸, 2칸, 1칸)
	(1칸, 1칸, 2칸)
	(2칸, 1칸, 1칸)
	(2칸, 2칸)
	의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 
	여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 예를 들어 4가 입력된다면, 5를 return하면 됩니다.
 * 
 * 
 * 	Solution : 1. DP를 이용하는 문제 -> 유사 문제 앞에 있었음
 * 			   2. max 갯수만큼 돌린다음에 동적으로 구해지는 값을 넣어주면 됨
 * 			   3. 각각 배열의 값은 값들의 연속성을 유지해준다는 것을 기억.
 * 
 * */

public class Solution {
	
    public long solution(int n) {
        int[] answer = new int[2001];
        answer[1] = 1;
        answer[2] = 2;
        
        for(int i=3; i<2001; i++) {
        	answer[i] = (answer[i-2] + answer[i-1]) % 1234567;
        }
        
        return answer[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 4;
		System.out.println(sol.solution(n));
	}
}