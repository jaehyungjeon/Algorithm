package FindKimToSeoul;

import java.util.*;

/*
 * Question : 
	String�� �迭 seoul�� element�� "Kim"�� ��ġ x�� ã��, "�輭���� x�� �ִ�"�� String�� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���. 
	seoul�� "Kim"�� ���� �� ���� ��Ÿ���� �߸��� ���� �ԷµǴ� ���� �����ϴ�.
 * 
 * 	Solution : 1. �ε��� ã�Ƽ� ����
 *  
 * */

public class Solution {

    public String solution(String[] seoul) {
        String answer = "";
        
        int count = 0;
        for(int i=0; i<seoul.length; i++) {
        	if(seoul[i].equals("Kim")) {
        		count = i;
        		break;
        	}
        }
        
        answer = "�輭���� " + count + "�� �ִ�";
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String[] seoul = {"Jane", "Kim"};
		System.out.println(sol.solution(seoul));
	}
}
