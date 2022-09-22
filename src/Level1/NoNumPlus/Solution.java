package Level1.NoNumPlus;

import java.util.ArrayList;
import java.util.List;

/*
 * Question : 
	0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
	numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
 * 
 * 	Solution : 1. for문 돌려서 0~9까지 중 없는걸 +시킨다.
 * */

public class Solution {
    
	public int solution(int[] numbers) {
        int answer = 0;
        
        List<Integer> map = new ArrayList<Integer>();
        for(int num : numbers) {
        	map.add(num);
        }
        
        for(int i=0; i<=9; i++) {
        	if(!map.contains(i)) {
        		answer+=i;
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] numbers = {1,2,3,4,6,7,8,0};
		System.out.println(sol.solution(numbers));
	}
}
