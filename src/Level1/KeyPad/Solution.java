package Level1.KeyPad;

/*
 * Question : 
	�� ��ȭ Ű�е忡�� �޼հ� �������� �����հ������� �̿��ؼ� ���ڸ��� �Է��Ϸ��� �մϴ�.
	�� ó�� �޼� �����հ����� * Ű�е忡 ������ �����հ����� # Ű�е� ��ġ���� �����ϸ�, �����հ����� ����ϴ� ��Ģ�� ������ �����ϴ�.
	
	�����հ����� �����¿� 4���� �������θ� �̵��� �� ������ Ű�е� �̵� �� ĭ�� �Ÿ��� 1�� �ش��մϴ�.
	���� ���� 3���� ���� 1, 4, 7�� �Է��� ���� �޼� �����հ����� ����մϴ�.
	������ ���� 3���� ���� 3, 6, 9�� �Է��� ���� ������ �����հ����� ����մϴ�.
	��� ���� 4���� ���� 2, 5, 8, 0�� �Է��� ���� �� �����հ����� ���� Ű�е��� ��ġ���� �� ����� �����հ����� ����մϴ�.
	4-1. ���� �� �����հ����� �Ÿ��� ���ٸ�, ���������̴� ������ �����հ���, �޼����̴� �޼� �����հ����� ����մϴ�.
	������� ���� ��ȣ�� ��� �迭 numbers, �޼��������� ������������ ���� ��Ÿ���� ���ڿ� hand�� �Ű������� �־��� ��, �� ��ȣ�� ���� �����հ����� �޼��� �� �������� ���� ��Ÿ���� ���ӵ� ���ڿ� ���·� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * Solution : 1. * -> 10 / # -> 12�� ���� 
 * 			  2. /3���� �� ���, 0�� ���� ����ó�� ����� �ϹǷ� �׳� ���񱳷� �ܼ��ϰ� ����
 * 			  3. �Ÿ��� ���� ���, hand�� ���� ���� ����
 * 
 * */

public class Solution {

	public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int leftNum = 10;
        int rightNum = 12;
        
        for(int cpNum : numbers) {
        	if(cpNum == 3 || cpNum == 6 || cpNum == 9) {
        		sb.append("R");
    			rightNum = cpNum;
        	} else if(cpNum == 1 || cpNum == 4 || cpNum == 7) {
        		sb.append("L");
    			leftNum = cpNum;
        	} else {
        		if(cpNum == 0) cpNum = 11;
    			int leftdist = Math.abs(cpNum - leftNum)/3 + Math.abs(cpNum - leftNum)%3;
    			int rightdist = Math.abs(cpNum - rightNum)/3 + Math.abs(cpNum - rightNum)%3;
    			
    			if(leftdist > rightdist) {
    				sb.append("R");
    				rightNum = cpNum;
    			} else if(leftdist < rightdist) {
    				sb.append("L");
    				leftNum = cpNum;
    			} else {
    				if(hand.equals("right")) {
    					sb.append("R");
    					rightNum = cpNum;
    				} else {
    					sb.append("L");
    					leftNum = cpNum;
    				}
    			}
 
        	}
        }
        	
        answer = sb.toString();
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
    	String hand = "right";
		System.out.println(sol.solution(numbers, hand));
		System.err.println("LRLLLRLLRRL");
	}
}
