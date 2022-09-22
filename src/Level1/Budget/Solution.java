package Level1.Budget;

import java.util.Arrays;

/*
 * Question : 
	S�翡���� �� �μ��� �ʿ��� ��ǰ�� ������ �ֱ� ���� �μ����� ��ǰ�� �����ϴµ� �ʿ��� �ݾ��� �����߽��ϴ�. 
	�׷���, ��ü ������ ������ �ֱ� ������ ��� �μ��� ��ǰ�� ������ �� ���� �����ϴ�. �׷��� �ִ��� ���� �μ��� ��ǰ�� ������ �� �� �ֵ��� �Ϸ��� �մϴ�.
	
	��ǰ�� ������ �� ���� �� �μ��� ��û�� �ݾ׸�ŭ�� ��� ������ ��� �մϴ�. 
	���� ��� 1,000���� ��û�� �μ����� ��Ȯ�� 1,000���� �����ؾ� �ϸ�, 1,000������ ���� �ݾ��� ������ �� ���� �����ϴ�.
	
	�μ����� ��û�� �ݾ��� ����ִ� �迭 d�� ���� budget�� �Ű������� �־��� ��, �ִ� �� ���� �μ��� ��ǰ�� ������ �� �ִ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 	Solution : 1. ������.. �����ѹ� �ξ� ���ְ� �� �ϳ��� ���ϴٰ� ���꺸�� Ŀ���� �ʴ� ������ result return ��Ű�� ���� ��������..?
 * 			   2. �ǳ�..!
 * 
 * */

public class Solution {

    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        int tot = 0;
        int count = 0;
        for(int i=0; i<d.length; i++) {
        	tot += d[i];
        	if(tot <= budget) {
        		count++;
        		answer = count;
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] d = {2,2,3,3};
    	int budget = 10;
		System.out.println(sol.solution(d, budget));
	}
}
