package Level1.StrangeStringMake;

import java.util.*;

/*
 * Question : 
	���ڿ� s�� �� �� �̻��� �ܾ�� �����Ǿ� �ֽ��ϴ�. �� �ܾ�� �ϳ� �̻��� ���鹮�ڷ� ���еǾ� �ֽ��ϴ�. 
	�� �ܾ��� ¦����° ���ĺ��� �빮�ڷ�, Ȧ����° ���ĺ��� �ҹ��ڷ� �ٲ� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ��ϼ���.
 * 
 * 	Solution : 1. �迭�� ���ڿ��� ��� ����
 * 			   2. �����̸� ī��Ʈ�� ���ġ �ؾ��ϹǷ� �����ϳ� ����
 * 			   3. ������ ��� empty�� 0���� �ʱ�ȭ, �ƴҰ�� ++
 * 			   4. empty%2=0 �̸� ¦�� �̹Ƿ� �ҹ���, Ȧ���� �빮�� += ����
 *  
 * */

public class Solution {
	
    public String solution(String s) {
        String answer = "";
        
        int empty = 0;
        String[] arr = s.split("");
        
        for(String b : arr) {
        	empty = b.contains(" ") ? 0 : empty + 1; // �����̸� �ʱ�ȭ
        	answer += (empty%2 == 0) ? b.toLowerCase() : b.toUpperCase();
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String s = "try hello world";
		System.out.println(sol.solution(s));
	}
}
