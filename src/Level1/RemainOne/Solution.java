package RemainOne;

import java.util.*;

/*
 * Question : 
	자연수 n이 매개변수로 주어집니다. 
	n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. 
	답이 항상 존재함은 증명될 수 있습니다.
 * 
 * 	Solution : 1. 리스트로 나머지가 1인 수 받아서
 * 			   2. 리스트 오름차순 정렬
 * 			   3. 첫번째 수 뽑으면 될 것이라 판단.
 * 
 * */

public class Solution {

	public static List<Integer> list = new ArrayList<Integer>();
	
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
        	if(n%i == 1) {
        		list.add(i);
        	}
        }
        
        list.stream().sorted();
        answer = list.get(0);
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 10;
		System.out.println(sol.solution(n));
	}
}
