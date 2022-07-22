package PlusMinusMerge;

/*
 * Question : 
	� �������� �ֽ��ϴ�. �� �������� ������ ���ʴ�� ���� ���� �迭 absolutes�� �� �������� ��ȣ�� ���ʴ�� ���� �Ҹ��� �迭 signs�� �Ű������� �־����ϴ�.
 	���� �������� ���� ���Ͽ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 	Solution : 1. sign�� ������ -1 ���ϰ� ���Ѵ�.
 * */

public class Solution {

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0; i<absolutes.length; i++) {
        	if(!signs[i]) { // ����
        		answer += absolutes[i] * -1;
        	} else {
        		answer += absolutes[i];
        	}
        }
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] absolutes = {4,7,12};
    	boolean[] signs = {true,false,true};
		System.out.println(sol.solution(absolutes, signs));
	}
}
