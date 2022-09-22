package Level1.TZOSYears;

import java.util.*;

/*
 * Question : 
	2016�� 1�� 1���� �ݿ����Դϴ�. 2016�� a�� b���� ���� �����ϱ��? 
	�� �� a ,b�� �Է¹޾� 2016�� a�� b���� ���� �������� �����ϴ� �Լ�, solution�� �ϼ��ϼ���. ������ �̸��� �Ͽ��Ϻ��� ����ϱ��� ���� SUN,MON,TUE,WED,THU,FRI,SAT
	�Դϴ�. ���� ��� a=5, b=24��� 5�� 24���� ȭ�����̹Ƿ� ���ڿ� "TUE"�� ��ȯ�ϼ���.
 * 
 * 	Solution : 1. 1, 3, 5, 7 / 8, 10, 12 -> 31
 * 			   2. 4, 6, 9, 11 -> 30
 * 			   3. 2 -> 29
 * 
 * */

public class Solution {

    public String solution(int a, int b) {
        String answer = "";
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int count = 0;
        for(int i=0; i<a-1; i++) {
        	count += day[i];
        }
        
        count += b-1;
        
        answer = days[count % 7];
        		
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int a = 5;
    	int b = 24;
		System.out.println(sol.solution(a, b));
	}
}
