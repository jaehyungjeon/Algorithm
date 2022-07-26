package FindDecimal;

import java.util.*;

/*
 * Question : 
	1���� �Է¹��� ���� n ���̿� �ִ� �Ҽ��� ������ ��ȯ�ϴ� �Լ�, solution�� ����� ������.
	
	�Ҽ��� 1�� �ڱ� �ڽ����θ� ���������� ���� �ǹ��մϴ�.
	(1�� �Ҽ��� �ƴմϴ�.)
 * 
 * 	Solution : 1. �Ҽ��� ���� ��, 0, 1�� �Ҽ��� �ƴϹǷ� 0���� ����
 * 			   2. ������ ��ŭ for���� ������ ���ʿ��� �ٽñ� i�� �����ŭ ���� �����ϸ� 0���� �迭 ����
 * 			   3. ���� �ᱣ�� �� �迭�� 0�� ���� ���� ���� ���� ��ŭ ++
 *  
 * */

public class Solution {
	
    public int solution(int n) {
	   int answer = 0;
       
	   int[] arr = new int[n+1];
	   arr[0] = arr[1] = 0;
	   
	   for(int i=2; i<=n; i++) {
		   arr[i] = i;
	   }
	   
	   for(int i=2; i<=(int)Math.sqrt(n); i++) {
		   if(arr[i] == 0) continue;
		   for(int j=2*i; j<=n; j+=i) {
			   arr[j] = 0;
		   }
	   }
	   
	   for(int i=0; i<arr.length; i++) {
		   if(arr[i] != 0) answer++;
	   }
       return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 10;
		System.out.println(sol.solution(n));
	}
}
