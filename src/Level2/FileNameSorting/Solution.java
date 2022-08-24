package Level2.FileNameSorting;

import java.util.*;

/*
 * Question : 
	�� ������ �ڵ� �׽�Ʈ�� �� ������ �����̶�� �⳪�� ����ε� ��ä�� ������ ����� īī���� �Ի��� ������ ���� ����� ���� ������ �ð� �Ǿ���.
	����� �������� ���α׷��� ���� ������ ��� ��� �־�, �̸� ������ ���ĵ� ���� ����� ���Ⱑ �����ߴ�. ������ �̸� ������ �����ϸ� ���߿� ������� ver-10.zip�� ver-9.zip���� ���� ǥ�õǱ� �����̴�.
	���� ��ȣ �ܿ��� ���ڰ� ���Ե� ���� ����� ���� �鿡�� �����ϱ� �����ߴ�. ������ ���� ����� ["img12.png", "img10.png", "img2.png", "img1.png"]�� ���, 
	�Ϲ����� ������ ["img1.png", "img10.png", "img12.png", "img2.png"] ���� ������, ���� ������ ���ĵ� ["img1.png", "img2.png", "img10.png", img12.png"] ���� �ξ� �ڿ�������.
	������ �ܼ��� ���� �ڵ� ���� �ƴ�, ���ϸ� ���Ե� ���ڸ� �ݿ��� ���� ����� ����� ���� ���α׷��� �����ϱ�� �ߴ�.
	
	�ҽ� ���� ����ҿ� ����� ���ϸ��� 100 ���� �̳���, ���� ��ҹ���, ����, ����(" "), ��ħǥ("."), ���� ��ȣ("-")������ �̷���� �ִ�. ���ϸ��� �����ڷ� �����ϸ�, ���ڸ� �ϳ� �̻� �����ϰ� �ִ�.
	
	���ϸ��� ũ�� HEAD, NUMBER, TAIL�� �� �κ����� �����ȴ�.
	
	HEAD�� ���ڰ� �ƴ� ���ڷ� �̷���� ������, �ּ��� �� ���� �̻��̴�.
	NUMBER�� �� ���ڿ��� �ִ� �ټ� ���� ������ ���ӵ� ���ڷ� �̷���� ������, ���ʿ� 0�� �� �� �ִ�. 0���� 99999 ������ ���ڷ�, 00000�̳� 0101 � �����ϴ�.
	TAIL�� �� ������ �κ�����, ���⿡�� ���ڰ� �ٽ� ��Ÿ�� ���� ������, �ƹ� ���ڵ� ���� �� �ִ�.
	���ϸ�	HEAD	NUMBER	TAIL
	foo9.txt	foo	9	.txt
	foo010bar020.zip	foo	010	bar020.zip
	F-15	F-	15	(�� ���ڿ�)
	���ϸ��� �� �κ����� ���� ��, ���� ���ؿ� ���� ���ϸ��� �����Ѵ�.
	
	���ϸ��� �켱 HEAD �κ��� �������� ���� ������ �����Ѵ�. �̶�, ���ڿ� �� �� ��ҹ��� ������ ���� �ʴ´�. MUZI�� muzi, MuZi�� ���� �ÿ� ���� ������ ��޵ȴ�.
	���ϸ��� HEAD �κ��� ��ҹ��� ���� �ܿ��� ���� ���, NUMBER�� ���� ������ �����Ѵ�. 9 < 10 < 0011 < 012 < 13 < 014 ������ ���ĵȴ�. ���� ���� 0�� ���õǸ�, 012�� 12�� ���� �ÿ� ���� ���� ������ ó���ȴ�.
	�� ������ HEAD �κа�, NUMBER�� ���ڵ� ���� ���, ���� �Է¿� �־��� ������ �����Ѵ�. MUZI01.zip�� muzi1.png�� �Է����� ������, ���� �Ŀ��� �Է� �� �־��� �� ������ ������ �ٲ��� �� �ȴ�.
	������ ���� ���ϸ� ���� ���α׷��� �����϶�.
 * 
 * 
 * 	Solution : 1. �迭 ��ü�� Sort�ϴ� ����
 * 			   2. ���ڸ� �������� split�Ͽ� 0��° �迭�� ���� ���� -> head (toLowerCase�� ���� ���ϸ��� ��ҹ��� ���� ��ȿȭ)
 * 			   3. h1, h2�� ���� ��� -> h1.compareTo(h2) == 0 �� ���̸�ŭ substring ���ش� 
 * 			   4. ������ ���̽��� �̾Ƽ� �ٽ��ѹ� ������������ ���� -> findNum���� ���ϵ� String ��
 * 			   5. ���� ������ ����� ���ؼ� ����
 * 			   6. return ����
 * */

public class Solution {
	
	public String[] solution(String[] files) {
		String[] answer = new String[files.length];
		
		Arrays.sort(files, (o1, o2) -> {
			String h1 = o1.split("[0-9]")[0].toLowerCase();
			String h2 = o2.split("[0-9]")[0].toLowerCase();
			
			if(h1.compareTo(h2) == 0) {
				String t1 = o1.substring(h1.length());
				String t2 = o2.substring(h2.length());
				
				return Integer.parseInt(findNum(t1)) - Integer.parseInt(findNum(t2));
			} else {
				return h1.compareTo(h2);
			}
		});
		
		for(int i=0; i<files.length; i++) {
			answer[i] = files[i];
		}
		
		return answer;
	}
	
	public static String findNum(String t) {
		StringBuilder sb = new StringBuilder();
		
		for(char c : t.toCharArray()) {
			if(Character.isDigit(c) && sb.length() <= 5) {
				sb.append(c);
			} else {
				return sb.toString();
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		System.out.println(sol.solution(files));
	}
}