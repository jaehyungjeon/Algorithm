package TrainingSuit;

import java.util.Arrays;

/*
 * Question : 
	���ɽð��� ������ ���, �Ϻ� �л��� ü������ �������߽��ϴ�. ������ ���� ü������ �ִ� �л��� �̵鿡�� ü������ �����ַ� �մϴ�. 
	�л����� ��ȣ�� ü�� ������ �Ű��� �־�, �ٷ� �չ�ȣ�� �л��̳� �ٷ� �޹�ȣ�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. 
	���� ���, 4�� �л��� 3�� �л��̳� 5�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. 
	ü������ ������ ������ ���� �� ���� ������ ü������ ������ ���� �ִ��� ���� �л��� ü�������� ���� �մϴ�.
	
	��ü �л��� �� n, ü������ �������� �л����� ��ȣ�� ��� �迭 lost, ������ ü������ ������ �л����� ��ȣ�� ��� �迭 reserve�� �Ű������� �־��� ��, 
	ü�������� ���� �� �ִ� �л��� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 	Solution : 1. ü���� ���� ��ȣ�� ���� ��ȣ�� ��ġ�ϸ� answer++; ���� ���Ҵ� ������(-1)
 * 			   2. ������ȣ�� ���� ��ȣ +- 1�̸�, answer++; ���� ���Ҵ� ������(-1)
 * 			   3. ù��° �׽�Ʈ�� ���ľ��� �������� �� �׽�Ʈ ���̽� ������ ���Ծ���...
 * 			   4. lost, reserve ��� �������� ����
 * 			   5. ������ ���� ������ �Ϻ� lost �������� ����� �� ũ�� ������ ������ �־���.
 * */

public class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
    	int answer = n - lost.length;
    	
    	Arrays.sort(lost);
    	Arrays.sort(reserve);
    	
    	for(int i=0; i<lost.length; i++) {
    		for(int j=0; j<reserve.length; j++) {
    			if(lost[i] == reserve[j]) { // ���� ��ȣ�� �н� ��ȣ�� ���� ���
    				answer++;
    				reserve[j] = -1;
    				lost[i] = -1;
    				break;
    			}
    		}
    	}
    	
    	for(int i=0; i<lost.length; i++) {
    		for(int j=0; j<reserve.length; j++) {
    			if((lost[i] == (reserve[j]-1) || lost[i] == (reserve[j]+1)) && reserve[j] > 0) {
    				answer++;
    				reserve[j] = -1;
    				lost[i] = -1;
    				break;
    			}
    		}
    	}
    	
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 5;
    	int[] lost = {2, 4};
    	int[] reserve = {3};
		System.out.println(sol.solution(n, lost, reserve));
	}
}
