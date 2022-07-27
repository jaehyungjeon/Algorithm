package Level2.OTTCountryNum;

import java.util.*;

/*
 * Question : 
	124 ���� �ֽ��ϴ�. 124 ���󿡼��� 10������ �ƴ� ������ ���� �ڽŵ鸸�� ��Ģ���� ���� ǥ���մϴ�.
	
	124 ���󿡴� �ڿ����� �����մϴ�.
	124 ���󿡴� ��� ���� ǥ���� �� 1, 2, 4�� ����մϴ�.
	���� �� 124 ���󿡼� ����ϴ� ���ڴ� ������ ���� ��ȯ�˴ϴ�.
	
	10����	124 ����	10����	124 ����
	1	1	6	14
	2	2	7	21
	3	4	8	22
	4	11	9	24
	5	12	10	41
	�ڿ��� n�� �Ű������� �־��� ��, n�� 124 ���󿡼� ����ϴ� ���ڷ� �ٲ� ���� return �ϵ��� solution �Լ��� �ϼ��� �ּ���.
 * 
 * 
 * 	Solution : 1. �������� ��, ������� �� ������ ���� -> 4, 1, 2
 * 			   2. ��Ʈ�� ���� �̾���̴� ������� �����⸦ ���� ���� ����� ����.
 * 			   3. n-1�� �������ν� �ش� �ڸ��� �°Բ� �����Ѵ�. 
 * 
 * */

public class Solution {

    public String solution(int n) {
    	String[] num = {"4", "1", "2"};
        String answer = "";
        
        while(n > 0) {
        	answer = num[n%3] + answer;
        	n = (n - 1)/3;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 4;
		System.out.println(sol.solution(n));
	}
}