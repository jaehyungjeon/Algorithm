package AddDigits;

import java.util.*;

/*
 * Question : 
	�ڿ��� N�� �־�����, N�� �� �ڸ����� ���� ���ؼ� return �ϴ� solution �Լ��� ����� �ּ���.
	������� N = 123�̸� 1 + 2 + 3 = 6�� return �ϸ� �˴ϴ�.
 * 
 * 	Solution : 1. Ÿ�Ժ�ȯ�ؼ� �迭��ŭ �����ش�.
 *  
 * */

public class Solution {
	
    public int solution(int n) {
        int answer = 0;
        
        String[] arr = String.valueOf(n).split("");
        
        for(int i=0; i<arr.length; i++) {
        	answer += Integer.parseInt(arr[i]);
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 123;
		System.out.println(sol.solution(n));
	}
}
