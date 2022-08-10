package Level2.PhoneList;

import java.util.*;

/*
 * Question : 
	��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
	��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.
	
	������ : 119
	���ؿ� : 97 674 223
	������ : 11 9552 4421
	��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution �Լ��� �Ű������� �־��� ��, 
	� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	Ư�� Ʃ���� ǥ���ϴ� ������ ��� ���ڿ� s�� �Ű������� �־��� ��, s�� ǥ���ϴ� Ʃ���� �迭�� ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. 1, 2 ... ������� ����
 * 			   2. ���� �Ͱ� ���Ͽ� �������� �� ���� ���� ������ return false;
 * 			   3. ������ Ȱ���ϸ� ��� �ӵ� �������Ƿ� �ٷ� true�� �����Ͽ���.
 * 
 * */

public class Solution {
	
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
		Arrays.sort(phone_book);
		
        for(int i=0; i<phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }
        
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[] phone_book = {"12","123","1235","567","88"};
		System.out.println(sol.solution(phone_book));
	}
}