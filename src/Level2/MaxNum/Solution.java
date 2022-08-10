package Level2.MaxNum;

import java.util.*;

/*
 * Question : 
	0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
	예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
	0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 * 
 * 
 * 	Solution : 1. Arrays.sort가 가장 큰 포인트 -> 두 값을 더하면서 큰것부터 내림차순 정렬하는 코드
 * 
 * */

public class Solution {
	
	Queue<Integer> q = new LinkedList<Integer>();
	
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr  = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
        	arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>() {

        	@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2+o1).compareTo(o1+o2);
			}
        });
        
        if(arr[0].equals("0")) return "0";
        
        for(String s : arr) {
        	answer += s;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(sol.solution(numbers));
	}
}