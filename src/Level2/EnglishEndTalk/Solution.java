package Level2.EnglishEndTalk;

import java.util.*;

/*
 * Question : 
	1���� n���� ��ȣ�� �پ��ִ� n���� ����� ���� �����ձ⸦ �ϰ� �ֽ��ϴ�. ���� �����ձ�� ������ ���� ��Ģ���� ����˴ϴ�.

	1������ ��ȣ ������� �� ����� ���ʴ�� �ܾ ���մϴ�.
	������ ����� �ܾ ���� �������� �ٽ� 1������ �����մϴ�.
	�ջ���� ���� �ܾ��� ������ ���ڷ� �����ϴ� �ܾ ���ؾ� �մϴ�.
	������ �����ߴ� �ܾ�� ����� �� �����ϴ�.
	�� ������ �ܾ�� �������� �ʽ��ϴ�.
	������ 3���� �����ձ⸦ �ϴ� ��Ȳ�� ��Ÿ���ϴ�.
	
	tank �� kick �� know �� wheel �� land �� dream �� mother �� robot �� tank
	
	�� �����ձ�� ������ ���� ����˴ϴ�.
	
	1�� ����� �ڽ��� ù ��° ���ʿ� tank�� ���մϴ�.
	2�� ����� �ڽ��� ù ��° ���ʿ� kick�� ���մϴ�.
	3�� ����� �ڽ��� ù ��° ���ʿ� know�� ���մϴ�.
	1�� ����� �ڽ��� �� ��° ���ʿ� wheel�� ���մϴ�.
	(��� ����)
	�����ձ⸦ ��� ������ ������ ����, 3�� ����� �ڽ��� �� ��° ���ʿ� ���� tank ��� �ܾ�� ������ �����ߴ� �ܾ��̹Ƿ� Ż���ϰ� �˴ϴ�.
	
	����� �� n�� ������� ������� ���� �ܾ� words �� �Ű������� �־��� ��, ���� ���� Ż���ϴ� ����� ��ȣ�� �� ����� �ڽ��� �� ��° ���ʿ� Ż���ϴ����� ���ؼ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. �������� ����� �ʾҴ� ����
 * 			   2. �����ܾ��� ���� ���� �ܾ��� ���� ���Ͽ� ���� ���� ���̽�
 * 			   3. ��ü ����Ʈ���� �ܾ ���Ͽ� �̹� �ִ� �ܾ��� ���̽�
 * 			   4. 2, 3�� ���̽��� ���, ���� �ߴ��ϰ� ���� ��ȯ
 * 
 * 
 * */

public class Solution {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int people = 0;
        int game = 1; 
        String prevWord = ""; // �����ձ� �����ܾ�
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<words.length; i++) {
        	String nowWord = words[i];
        	people++;
        	
        	if(i > 0) {
        		char prevChar = prevWord.charAt(prevWord.length() - 1); // ���ܾ�
        		char nowChar = nowWord.charAt(0); // ù��° �ܾ�
        		
        		if(prevChar != nowChar || map.containsKey(nowWord)) { // �� �ܾ ���� �ʰų� �̹� �ʿ� �ܾ ���� ��� break;
        			answer[0] = people;
        			answer[1] = game;
        			break;
        		}
        	}
        	
        	map.put(nowWord, 0);
        	prevWord = nowWord; // �ܾ� Switching
        	
        	if(people == n) { // �迭�� ũ�⸸ŭ reset
        		people = 0;
        		game++;
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		System.out.println(sol.solution(n, words));
	}
}