package DartGame;

import java.util.*;

/*
 * Question : 
	īī���忡 �� �� ��° ��! �ɽ��� ��? īī���� ���Ӻ�~
	
	Game Star
	
	īī���� ���Ӻ��� �Ϲݱ� �ű� ���񽺷� ��Ʈ ������ ����ϱ�� �ߴ�. ��Ʈ ������ ��Ʈ�ǿ� ��Ʈ�� �� ���� ���� �� ������ �հ�� �Ƿ��� �ܷ�� ��������, ��ΰ� ������ ��� �� �ִ�.
	�� �Ի��� ������ �ڵ� �Ƿ��� �����޾� ������ �ٽ� �κ��� ���� ��� ������ �ð� �Ǿ���. ��Ʈ ������ ���� ��� ������ �Ʒ��� ����.
	
	��Ʈ ������ �� 3���� ��ȸ�� �����ȴ�.
	�� ��ȸ���� ���� �� �ִ� ������ 0������ 10�������̴�.
	������ �Բ� Single(S), Double(D), Triple(T) ������ �����ϰ� �� ���� ��÷ �� �������� 1����, 2����, 3���� (����1 , ����2 , ����3 )���� ���ȴ�.
	�ɼ����� ��Ÿ��(*) , ������(#)�� �����ϸ� ��Ÿ��(*) ��÷ �� �ش� ������ �ٷ� ���� ���� ������ �� 2��� �����. ������(#) ��÷ �� �ش� ������ ���̳ʽ��ȴ�.
	��Ÿ��(*)�� ù ��° ��ȸ������ ���� �� �ִ�. �� ��� ù ��° ��Ÿ��(*)�� ������ 2�谡 �ȴ�. (���� 4�� ����)
	��Ÿ��(*)�� ȿ���� �ٸ� ��Ÿ��(*)�� ȿ���� ��ø�� �� �ִ�. �� ��� ��ø�� ��Ÿ��(*) ������ 4�谡 �ȴ�. (���� 4�� ����)
	��Ÿ��(*)�� ȿ���� ������(#)�� ȿ���� ��ø�� �� �ִ�. �� ��� ��ø�� ������(#)�� ������ -2�谡 �ȴ�. (���� 5�� ����)
	Single(S), Double(D), Triple(T)�� �������� �ϳ��� �����Ѵ�.
	��Ÿ��(*), ������(#)�� �������� �� �� �ϳ��� ������ �� ������, �������� ���� ���� �ִ�.
	0~10�� ������ ���� S, D, T, *, #�� ������ ���ڿ��� �Էµ� �� �������� ��ȯ�ϴ� �Լ��� �ۼ��϶�.
 * 
 * 	Solution : 1. 
 * */

public class Solution {

    public static boolean isNumeric(char s) {
        if (s < '0' || s > '9') {
            return false;
        }
        
        return true;
    }
	
    public int solution(String dartResult) {
        int answer = 0;
        int[] arr = new int[3];
        int idx = 0;
        String tempString = "";
        int tempNum = 0;
        
        for(int i=0; i<dartResult.length(); i++) {
        	char tmp = dartResult.charAt(i);
        	
        	if(isNumeric(tmp)) { // ������ ��,
        		tempString += String.valueOf(tmp);
        	} else if(tmp == 'S' || tmp == 'D' || tmp == 'T') {
        		tempNum = Integer.parseInt(tempString);
        		switch(tmp) {
        			case 'S' :
        				tempNum = (int)Math.pow(tempNum, 1);
        				break;
        			case 'D' :
        				tempNum = (int)Math.pow(tempNum, 2);
        				break;
        			case 'T' :
        				tempNum = (int)Math.pow(tempNum, 3);
        				break;
        		}
        		arr[idx++] = tempNum;
        		tempString = "";
        	} else {
        		if(tmp == '#') {
        			arr[idx - 1] *= -1;
        		} else {
        			arr[idx - 1] *= 2;
        			if(idx - 2 >= 0) {
        				arr[idx - 2] *= 2;
        			}
        		}
        	}
        }
        
        for(int val : arr) {
        	answer += val;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String dartResult = "1S*2T*3S";
		System.out.println(sol.solution(dartResult));
	}
}
