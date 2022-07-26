package PhoneNumHide;

import java.util.*;

/*
 * Question : 
	프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
	전화번호가 문자열 phone_number로 주어졌을 때, 
	전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

 * 
 * 	Solution : 1. char 배열로 변환한 다음에 4개를 제외한 나머지를 *로 변환해주면 됨
 * 			   2. return은 해당 char 배열을 String으로 변환하여 출력
 *  
 * */

public class Solution {
	
    public String solution(String phone_number) {
        char[] c = phone_number.toCharArray();
        for(int i=0; i<phone_number.length()-4; i++) {
        	c[i] = '*';
        }
        
        return String.valueOf(c);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String phone_number = "01033324444";
		System.out.println(sol.solution(phone_number));
	}
}
