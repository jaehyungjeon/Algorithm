package Level1.TwoNumPlus;

import java.util.Arrays;
import java.util.HashSet;

/*
 * Question : 
	정수 배열 numbers가 주어집니다. 
	numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 * 
 * 	Solution : 1. for문으로 덧셈 해주고..
 * 			   2. HaseSet 이용해서 중복 제거한다음
 * 			   3. java Stream 이용하여 정렬 후 배열로 정의 한 뒤 return
 * 
 * */

public class Solution {

	public HashSet<Integer> set = new HashSet<Integer>();
	
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        Arrays.sort(numbers);
        
        for(int i=0; i<numbers.length; i++) {
        	for(int j=i+1; j<numbers.length; j++) {
        		set.add(numbers[i] + numbers[j]);
        	}
        }
        
        answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] numbers = {5,0,2,7};
		System.out.println(sol.solution(numbers));
	}
}
