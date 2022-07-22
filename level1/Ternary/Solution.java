package Ternary;

import java.util.ArrayList;
import java.util.List;

/*
 * Question : 
	�ڿ��� n�� �Ű������� �־����ϴ�. 
	n�� 3���� �󿡼� �յڷ� ������ ��, �̸� �ٽ� 10�������� ǥ���� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 	Solution : 1. ���� ������ /3�� �� �������� ������� ������ ������������ ������ �� ��
 * 			   2. �� ���� ����Ʈ ������ ���� ���� for���� ���� �������� ����
 * 			   3. *3�� �����ϹǷ� �������� �ϳ� �ΰ� list�� �������� �� * �������� answer�� ������
 * 
 * */

public class Solution {

	public List<Integer> list = new ArrayList<Integer>();
	
    public int solution(int n) {
        int answer = 0;
        
        while(n != 0) {
        	list.add(n%3);
        	n = n/3;
        }
        
        int plus = 1;
        for(int i=list.size()-1; i>=0; i--) {
        	answer += (list.get(i) * plus);
        	plus *= 3;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 45;
		System.out.println(sol.solution(n));
	}
}
