package Level1.DividedNumArray;

import java.util.*;

/*
 * Question : 
	array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
	divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 * 
 * 	Solution : 1. 나머지 0인것 찾아서 넣는다.
 * 			   2. 없으면 -1 넣는다.
 * 			   3. 리스트로 받은 것을 정렬하여 배열에 넣는다.
 * 
 * */

public class Solution {

	public List<Integer> list = new ArrayList<Integer>();
	
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        
        for(int i=0; i<arr.length; i++) {
        	if(arr[i]%divisor == 0) {
        		list.add(arr[i]);
        	}
        }
        
        if(list.isEmpty()) {
        	list.add(-1);
        }
        
        answer = list.stream().sorted().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] arr = {2, 36, 1, 3};
    	int divisor = 1;
		System.out.println(sol.solution(arr, divisor));
	}
}
