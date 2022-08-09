package Level2.NewsClustering;

import java.util.*;

/*
 * Question : 
	���� ��л翡�� ������� ����, Ư�� �Ӻ��� ������ ���� �������� ������ ��簡 ���� ���� �ʿ��� ��縦 ã�Ⱑ ��ƴ�. 
	Daum ������ ���� ������ �ð� �� ���Ի�� Ʃ��� ����ڵ��� ���ϰ� �پ��� ������ ã�ƺ� �� �ֵ��� �������� �����ϴ� ������ �ð� �Ǿ���.

	������ ������ ��� ���� Ʃ��� �켱 �ֱ� ȭ���� �ǰ� �ִ� "īī�� ���� ������ ��ä" ���� ��縦 �˻��غ��Ҵ�.
	
	īī�� ù ��ä..'����ε�' ��� ä��
	īī��, �պ� �� ù ��ä.. ����ε� �������� ������ ä��
	īī��, ����ε� �������� ���� ������ ��ä
	īī�� ��ä, ���� ������ �ڵ� �ɷ¸� ����
	īī��, ���� ��ä.. "�ڵ� �Ƿ¸� ����"
	īī�� "�ڵ� �ɷ¸����� 2018 ���� ������ �̴´�"
	����� ������ �������� "����ε� ����"�� �ָ��ϴ� ���� "�ڵ� �׽�Ʈ"�� �ָ��ϴ� ���� ������ �� �߰��ߴ�. Ʃ��� �̵��� ���� ��� �����ָ� īī�� ��ä ���� ��縦 ã�ƺ��� ����ڿ��� ������ ��;���.
	
	������ ��縦 ���� ������ ���ϱ� ���ؼ� ���� �ڷḦ �����ϴ� Ʃ��� "��ī�� ���絵"��� ����� ã�Ƴ´�.
	��ī�� ���絵�� ���� ���� ���絵�� �˻��ϴ� ���� ��� ���� �ϳ��� �˷��� �ִ�. �� ���� A, B ������ ��ī�� ���絵 J(A, B)�� �� ������ ������ ũ�⸦ �� ������ ������ ũ��� ���� ������ ���ǵȴ�.
	
	���� ��� ���� A = {1, 2, 3}, ���� B = {2, 3, 4}��� �� ��, ������ A �� B = {2, 3}, ������ A �� B = {1, 2, 3, 4}�� �ǹǷ�, 
	���� A, B ������ ��ī�� ���絵 J(A, B) = 2/4 = 0.5�� �ȴ�. ���� A�� ���� B�� ��� �������� ��쿡�� �������� ���ǵ��� ������ ���� J(A, B) = 1�� �����Ѵ�.
	
	��ī�� ���絵�� ������ �ߺ��� ����ϴ� �������տ� ���ؼ� Ȯ���� �� �ִ�. �������� A�� ���� "1"�� 3�� ������ �ְ�, �������� B�� ���� "1"�� 5�� ������ �ִٰ� ����. 
	�� ���������� ������ A �� B�� ���� "1"�� min(3, 5)�� 3��, ������ A �� B�� ���� "1"�� max(3, 5)�� 5�� ������ �ȴ�. 
	�������� A = {1, 1, 2, 2, 3}, �������� B = {1, 2, 2, 4, 5}��� �ϸ�, ������ A �� B = {1, 2, 2}, ������ A �� B = {1, 1, 2, 2, 3, 4, 5}�� �ǹǷ�, 
	��ī�� ���絵 J(A, B) = 3/7, �� 0.42�� �ȴ�.
	
	�̸� �̿��Ͽ� ���ڿ� ������ ���絵�� ����ϴµ� �̿��� �� �ִ�. 
	���ڿ� "FRANCE"�� "FRENCH"�� �־����� ��, �̸� �� ���ھ� ��� ���������� ���� �� �ִ�. ���� {FR, RA, AN, NC, CE}, {FR, RE, EN, NC, CH}�� �Ǹ�, 
	�������� {FR, NC}, �������� {FR, RA, AN, NC, CE, RE, EN, CH}�� �ǹǷ�, �� ���ڿ� ������ ��ī�� ���絵 J("FRANCE", "FRENCH") = 2/8 = 0.25�� �ȴ�.
 * 
 * 
 * 	Solution : 1. str1�� 2���� �ɰ��� ��� ������ �ϳ� �ʿ�
 * 			   2. str2�� 2���� �ɰ��� ��� ������ �ϳ� �ʿ�
 * 			   3. ��ҹ��� ��ȯ�ؼ� ��ġ�ϸ� ������ ���� ++
 * 			   4. �ߺ��� ������ ������ ���� ++
 * 
 * */

public class Solution {
    public static HashMap<String, Integer> str1List = new HashMap<String, Integer>();
    public static HashMap<String, Integer> str2List = new HashMap<String, Integer>();
    public static List<String> set = new ArrayList<String>();
    
    public int solution(String str1, String str2) {
        int answer = 0;
        int inter = 0;
        int union = 0;
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        for(int i=0; i<str1.length() - 1; i++) {
        	String s = str1.substring(i, i+2).replaceAll("[^A-Z]", "");
        	if(s.length() < 2) continue;
        	str1List.put(s, str1List.getOrDefault(s, 0) + 1);
        }
        
        for(int i=0; i<str2.length() - 1; i++) {
        	String s = str2.substring(i, i+2).replaceAll("[^A-Z]", "");
        	if(s.length() < 2) continue;
        	str2List.put(s, str2List.getOrDefault(s, 0) + 1);
        }
        
        if(str1List.size() == 0 && str2List.size() == 0) return 65536;
        
        for(String k : str1List.keySet()) {
        	if(str2List.containsKey(k)) {
        		inter += Math.min(str1List.get(k), str2List.get(k));
        		union += Math.max(str1List.get(k), str2List.get(k));
        		str2List.remove(k);
        	} else {
        		union += str1List.get(k);
        	}
        }
        
        for(String a : str2List.keySet()) {
        	union += str2List.get(a);
        }
        
        return (int)((double)inter / union * 65536);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String str1 = "handshake";
		String str2 = "shake hands";
		System.out.println(sol.solution(str1, str2));
	}
}