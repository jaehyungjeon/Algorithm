package Divisor;

import java.util.HashMap;
import java.util.Map;

/*
 * Question : 
	�� ���� left�� right�� �Ű������� �־����ϴ�. 
	left���� right������ ��� ���� �߿���, ����� ������ ¦���� ���� ���ϰ�, ����� ������ Ȧ���� ���� �� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 	Solution : 1. 
 * 
 * */

public class Solution {

	public Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++) {
        	for(int j=1; j<=i; j++) {
        		int num = i%j;
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
