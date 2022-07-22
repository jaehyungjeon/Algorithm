package Ternary;

import java.util.ArrayList;
import java.util.List;

/*
 * Question : 
	자연수 n이 매개변수로 주어집니다. 
	n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 * 
 * 	Solution : 1. 받은 인자의 /3을 한 나머지를 순서대로 담으면 오름차순으로 값들이 들어갈 것
 * 			   2. 들어간 것의 리스트 사이즈 부터 감소 for문을 돌려 역순으로 진행
 * 			   3. *3씩 증가하므로 기준점을 하나 두고 list의 순차적인 값 * 증감값을 answer에 더해줌
 * 
 * */

public class Solution {

	public List<Integer> list = new ArrayList<Integer>();
	
    public int solution(int n) {
        int answer = 0;
        
        while(n != 0) {
        	list.add(n%3);
        	n = n/3;
        }
        
        int plus = 1;
        for(int i=list.size()-1; i>=0; i--) {
        	answer += (list.get(i) * plus);
        	plus *= 3;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 45;
		System.out.println(sol.solution(n));
	}
}
