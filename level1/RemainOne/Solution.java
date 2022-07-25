package RemainOne;

import java.util.*;

/*
 * Question : 
	�ڿ��� n�� �Ű������� �־����ϴ�. 
	n�� x�� ���� �������� 1�� �ǵ��� �ϴ� ���� ���� �ڿ��� x�� return �ϵ��� solution �Լ��� �ϼ����ּ���. 
	���� �׻� �������� ����� �� �ֽ��ϴ�.
 * 
 * 	Solution : 1. ����Ʈ�� �������� 1�� �� �޾Ƽ�
 * 			   2. ����Ʈ �������� ����
 * 			   3. ù��° �� ������ �� ���̶� �Ǵ�.
 * 
 * */

public class Solution {

	public static List<Integer> list = new ArrayList<Integer>();
	
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
        	if(n%i == 1) {
        		list.add(i);
        	}
        }
        
        list.stream().sorted();
        answer = list.get(0);
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 10;
		System.out.println(sol.solution(n));
	}
}
