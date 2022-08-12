package Level2.JadenCase;

import java.util.*;

/*
 * Question : 
	JadenCase�� ��� �ܾ��� ù ���ڰ� �빮���̰�, �� ���� ���ĺ��� �ҹ����� ���ڿ��Դϴ�. ��, ù ���ڰ� ���ĺ��� �ƴ� ������ �̾����� ���ĺ��� �ҹ��ڷ� ���� �˴ϴ�. (ù ��° ����� �� ����)
	���ڿ� s�� �־����� ��, s�� JadenCase�� �ٲ� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. ����� �ʾҴ� ����
 * 			   2. ù��°�� �����̸� first �ڿ��� ������ ù��° ���ڰ� �ð��̹Ƿ� boolean�� true�� ����
 * 			   3. ���ʿ� �ҹ��ڷ� �������� ù��°�� �빮�ڷ� ����°� �ð��� ���� �� ����.
 * 
 * */

public class Solution {

    public String solution(String s) {
        String answer = "";
        String[] arr = s.toLowerCase().split("");
        
        boolean first = true;
        for(String str : arr) {
        	answer += first ? str.toUpperCase() : str;
        	first = str.equals(" ") ? true : false;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String s = "3people unFollowed me";
		System.out.println(sol.solution(s));
	}
}