package Level2.KDecimalNum;

import java.util.*;

/*
 * Question : 
	���� ���� n�� �־����ϴ�. �� ���ڸ� k������ �ٲ��� ��, ��ȯ�� �� �ȿ� �Ʒ� ���ǿ� �´� �Ҽ�(Prime number)�� �� ������ �˾ƺ��� �մϴ�.

	0P0ó�� �Ҽ� ���ʿ� 0�� �ִ� ���
	P0ó�� �Ҽ� �����ʿ��� 0�� �ְ� ���ʿ��� �ƹ��͵� ���� ���
	0Pó�� �Ҽ� ���ʿ��� 0�� �ְ� �����ʿ��� �ƹ��͵� ���� ���
	Pó�� �Ҽ� ���ʿ� �ƹ��͵� ���� ���
	��, P�� �� �ڸ����� 0�� �������� �ʴ� �Ҽ��Դϴ�.
	���� ���, 101�� P�� �� �� �����ϴ�.
	���� ���, 437674�� 3������ �ٲٸ� 211020101011�Դϴ�. ���⼭ ã�� �� �ִ� ���ǿ� �´� �Ҽ��� ���ʺ��� ������� 211, 2, 11�� ������, �� 3���Դϴ�. (211, 2, 11�� k�������� ������ ���� �ƴ�, 10�������� ������ �� �Ҽ����� �Ѵٴ� ���� �����մϴ�.) 211�� P0 ���¿��� ã�� �� ������, 2�� 0P0����, 11�� 0P���� ã�� �� �ֽ��ϴ�.
	
	���� n�� k�� �Ű������� �־����ϴ�. n�� k������ �ٲ��� ��, ��ȯ�� �� �ȿ��� ã�� �� �ִ� �� ���ǿ� �´� �Ҽ��� ������ return �ϵ��� solution �Լ��� �ϼ��� �ּ���.
 * 
 * 
 * 	Solution : 1. �Ҽ��� ã�� ������ �ø��� ����
 * 			   2. �߰��� 00�� �� ��� -> 1�ܰ�� split("0")���� ������ ��, �迭�� ���̸� continue;
 * 			   3. �Ҽ��� ã�� isPrime���� int�� �־��� ��� �׽�Ʈ ���̽� 1, 11 ���� �߻�
 * 			   4. �ڷ����� �����̹Ƿ� long���� ��ȯ�Ͽ� �ǽ� -> ���
 * 
 * 
 * */

public class Solution {

    public int solution(int n, int k) {
        int answer = 0;
        
        String str = Integer.toString(n, k); // n�������� ��ȯ
        String[] strArr = str.split("0");
        
        for(String s : strArr) {
        	if(s.equals("")) continue;
        	if(isPrime(s)) answer++;
        }
        
        return answer;
    }
    
    public static boolean isPrime(String s) {
    	long n = Long.parseLong(s);
    	if(n <= 1) {
    		return false;
    	}
    	
    	for (int i = 2; i<=(int)Math.sqrt(n); i++) {
    		if (n % i == 0) {
    			return false;
    		}
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 110011;
		int k = 10;
		System.out.println(sol.solution(n, k));
	}
}