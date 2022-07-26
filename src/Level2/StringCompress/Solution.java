package Level2.StringCompress;

import java.util.*;

/*
 * Question : 
	������ ó�� �������� �ǰ� ���� "����ġ"�� ���ڿ��� �����ϴ� ����� ���� ���θ� �ϰ� �ֽ��ϴ�. 
	�ֱٿ� �뷮�� ������ ó���� ���� ������ ��ս� ���� ����� ���� ���θ� �ϰ� �ִµ�, 
	���ڿ����� ���� ���� �����ؼ� ��Ÿ���� ���� �� ������ ������ �ݺ��Ǵ� ������ ǥ���Ͽ� �� ª�� ���ڿ��� �ٿ��� ǥ���ϴ� �˰����� �����ϰ� �ֽ��ϴ�.
	
	������ ���� "aabbaccc"�� ��� "2a2ba3c"(���ڰ� �ݺ����� �ʾ� �ѹ��� ��Ÿ�� ��� 1�� ������)�� ���� ǥ���� �� �ִµ�, 
	�̷��� ����� �ݺ��Ǵ� ���ڰ� ���� ��� ������� ���ٴ� ������ �ֽ��ϴ�. ���� ���, "abcabcdede"�� ���� ���ڿ��� ���� ������� �ʽ��ϴ�. 
	"����ġ"�� �̷��� ������ �ذ��ϱ� ���� ���ڿ��� 1�� �̻��� ������ �߶� �����Ͽ� �� ª�� ���ڿ��� ǥ���� �� �ִ��� ����� ã�ƺ����� �մϴ�.
	
	���� ���, "ababcdcdababcdcd"�� ��� ���ڸ� 1�� ������ �ڸ��� ���� ������� ������, 2�� ������ �߶� �����Ѵٸ� "2ab2cd2ab2cd"�� ǥ���� �� �ֽ��ϴ�. 
	�ٸ� ������� 8�� ������ �߶� �����Ѵٸ� "2ababcdcd"�� ǥ���� �� ������, �̶��� ���� ª�� �����Ͽ� ǥ���� �� �ִ� ����Դϴ�.
	
	�ٸ� ����, "abcabcdede"�� ���� ���, ���ڸ� 2�� ������ �߶� �����ϸ� "abcabc2de"�� ������, 
	3�� ������ �ڸ��ٸ� "2abcdede"�� �Ǿ� 3�� ������ ���� ª�� ���� ����� �˴ϴ�. �̶� 3�� ������ �ڸ��� �������� ���� ���ڿ��� �״�� �ٿ��ָ� �˴ϴ�.
	
	������ ���ڿ� s�� �Ű������� �־��� ��,
	���� ������ ������� 1�� �̻� ������ ���ڿ��� �߶� �����Ͽ� ǥ���� ���ڿ� �� ���� ª�� ���� ���̸� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 	Solution : 1. ������ŭ �ɰ��� �ݺ��� �ϸ鼭 ������ �տ� ���ڷ� �ٲ��ִ� ����
 * 			   2. ���������� ����+���� ������ �� �������� �ּ� ���� ���ϴ� ��
 * 
 * */

public class Solution {

	public int solution(String s) {
		int answer = s.length();
		
		for(int i=1; i<=s.length()/2; i++) {
			String str = s.substring(0, i); // 0 ~ i��°���� �ڸ�
			String comStr = "";
			String totalStr = "";
			int cnt = 1;
					
			for(int j=i; j<s.length(); j+=i) {
				if((j+i) < s.length()) {
					comStr = s.substring(j, j+i);
 				} else {
 					comStr = s.substring(j, s.length()); // ���� �ܰ�
 				}
				
				if(str.equals(comStr)) {
					cnt++;
				} else {
					if(cnt == 1) {
						totalStr += str;
						str = comStr;
					} else {
						totalStr += (cnt + str);
						str = comStr;
						cnt = 1;
					}
				}
			}
			
			if(totalStr.length() != s.length()) {
				if(cnt > 1) {
					totalStr += (cnt + comStr);
				} else {
					totalStr += comStr;
				}
			}
			
			answer = Math.min(answer, totalStr.length());
		}
		
		return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String s = "xababcdcdababcdcd";
		System.out.println(sol.solution(s));
	}
}
