package Level1.Divisor;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Question : 
	두 정수 left와 right가 매개변수로 주어집니다. 
	left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 * 
 * 	Solution : 1. 맵으로 받아서 키값에 따라 값을 변경 -> 나머지가 0이면 약수일거니까 그때 증가
 * 			   2. map값 기준 value가 짝수 -> 키값 더하고 아니면 뺀다.
 * 
 * */

public class Solution {

	public Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
        	for(int j=1; j<=i; j++) {
        		int num2 = i%j;
        		if(num2 == 0) {
        			map.put(i, map.getOrDefault(i, 0)+1);
        		} else {
        			map.put(i, map.getOrDefault(i, 0));
        		}
        	}
        }

        for(Entry<Integer, Integer> key : map.entrySet()) {
        	if(key.getValue()%2 == 0) { // 짝수
        		answer += key.getKey();
        	} else { // 홀수
        		answer -= key.getKey();
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int left = 13;
    	int right = 17;
		System.out.println(sol.solution(left, right));
	}
}
