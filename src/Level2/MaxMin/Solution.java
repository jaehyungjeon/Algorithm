package Level2.MaxMin;

import java.util.*;

/*
 * Question : 
	���ڿ� s���� �������� ���е� ���ڵ��� ����Ǿ� �ֽ��ϴ�. str�� ��Ÿ���� ���� �� �ּҰ��� �ִ밪�� ã�� �̸� "(�ּҰ�) (�ִ밪)"������ ���ڿ��� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���.
	������� s�� "1 2 3 4"��� "1 4"�� �����ϰ�, "-1 -2 -3 -4"��� "-4 -1"�� �����ϸ� �˴ϴ�.
 * 
 * 	output : -4 -1
 * 
 * 	Solution : 1. max, min ���ϱ�.. ����� �ʾ���.
 * 
 * */

public class Solution {

    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        
        int max = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[0]);
        for(int i=0; i<arr.length; i++) {
        	int tmp = Integer.parseInt(arr[i]);
        	max = Math.max(max, tmp);
        	min = Math.min(min, tmp);
        }
        
        sb.append(min + " " + max);
        answer = sb.toString();
        return answer;
    }
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String s = "-1 -2 -3 -4";
		System.out.println(sol.solution(s));
	}
}