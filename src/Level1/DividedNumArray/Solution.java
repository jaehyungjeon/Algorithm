package Level1.DividedNumArray;

import java.util.*;

/*
 * Question : 
	array�� �� element �� divisor�� ������ �������� ���� ������������ ������ �迭�� ��ȯ�ϴ� �Լ�, solution�� �ۼ����ּ���.
	divisor�� ������ �������� element�� �ϳ��� ���ٸ� �迭�� -1�� ��� ��ȯ�ϼ���.
 * 
 * 	Solution : 1. ������ 0�ΰ� ã�Ƽ� �ִ´�.
 * 			   2. ������ -1 �ִ´�.
 * 			   3. ����Ʈ�� ���� ���� �����Ͽ� �迭�� �ִ´�.
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
