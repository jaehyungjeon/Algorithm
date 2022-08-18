package Level2.LineMethod;

import java.util.*;

/*
 * Question : 
	n명의 사람이 일렬로 줄을 서고 있습니다. n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨져 있습니다. n명이 사람을 줄을 서는 방법은 여러가지 방법이 있습니다. 
	예를 들어서 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.

	[1, 2, 3]
	[1, 3, 2]
	[2, 1, 3]
	[2, 3, 1]
	[3, 1, 2]
	[3, 2, 1]
	사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때, k번째 방법을 return하는 solution 함수를 완성해주세요.
 * 
 * 
 * 	Solution : 1. num = 최대 경우의 수 / idx = answer 반환을 위한 인덱스
 * 			   2. 리스트에 n이하의 수를 담음
 * 			   3. while문을 통해, 순서에 맞는 리스트 값을 꺼내옴 -> 해당 부분이 막혀서 인터넷 참고
 * 			   4. 리스트를 지워가면서 순서 세팅
 * 			   5. 나머지를 k에 반환
 * 
 * */

public class Solution {
	
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
		List<Integer> list = new ArrayList<>();
        long num = 1;
        int idx = 0;
		for(int i=1; i<=n; i++) {
			list.add(i);
			num *= i;
		}
		
        k--;
        while(idx < answer.length) {
        	num /= (n--);
        	int i = (int)(k/num);
        	answer[idx++] = list.get(i);
        	list.remove(i);
        	k %= num;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 3;
		long k = 5;
		System.out.println(sol.solution(n, k));
	}
}