package Level2.NextBigNumber;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	�ڿ��� n�� �־����� ��, n�� ���� ū ���ڴ� ������ ���� ���� �մϴ�.

	���� 1. n�� ���� ū ���ڴ� n���� ū �ڿ��� �Դϴ�.
	���� 2. n�� ���� ū ���ڿ� n�� 2������ ��ȯ���� �� 1�� ������ �����ϴ�.
	���� 3. n�� ���� ū ���ڴ� ���� 1, 2�� �����ϴ� �� �� ���� ���� �� �Դϴ�.
	���� �� 78(1001110)�� ���� ū ���ڴ� 83(1010011)�Դϴ�.
	
	�ڿ��� n�� �Ű������� �־��� ��, n�� ���� ū ���ڸ� return �ϴ� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. ���� dfs�� Ǯ����..
 * 			   2. n���� ū ���ڸ� ����ؼ� ���ذ��鼭 1�� ������ ��ġ�� ����� ���� �ٷ� ���Ͻ�Ű�� ��.
 * 			   3. �ٸ� �ҽ����� �ӵ������� ������..?
 * 
 * 
 * */

public class Solution {

	public static int answer;
	
    public int solution(int n) {
    	answer = 0;
        int cnt = count(n);
        
        dfs(n+1, cnt);
        return answer;
    }

    public static void dfs(int n, int cnt) {
    	int tmp = count(n);
    	
    	if(tmp == cnt) {
    		answer = n;
    	} else {
    		dfs(n+1, cnt);
    	}
    }
    
    public static int count(int n) {
    	int count = 0;
    	String Binary = Integer.toBinaryString(n);
        for(int i=0; i<Binary.length(); i++) {
        	if(Binary.charAt(i) == '1') {
        		count++;
        	}
        }
        
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 15;
		System.out.println(sol.solution(n));
	}
}