package Level1.Average;

import java.util.*;

/*
 * Question : 
	������ ��� �ִ� �迭 arr�� ��հ��� return�ϴ� �Լ�, solution�� �ϼ��غ�����.

 * 
 * 	Solution : 1. ��ü �� / ��ü ����
 *  
 * */

public class Solution {
	
    public double solution(int[] arr) {
        double answer = 0;
        
        for(int i=0; i<arr.length; i++) {
        	answer += arr[i];
        }
        
        answer /= arr.length;
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] arr = {1, 2, 3, 4};
		System.out.println(sol.solution(arr));
	}
}
