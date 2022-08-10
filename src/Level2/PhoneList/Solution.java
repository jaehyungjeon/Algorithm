package Level2.PhoneList;

import java.util.*;

/*
 * Question : 
	전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
	전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
	
	구조대 : 119
	박준영 : 97 674 223
	지영석 : 11 9552 4421
	전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 
	어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
	
	특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * 	Solution : 1. 1, 2 ... 순서대로 정렬
 * 			   2. 다음 것과 비교하여 시작했을 때 같은 것이 있으면 return false;
 * 			   3. 변수를 활용하면 출력 속도 낮아지므로 바로 true로 리턴하였음.
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