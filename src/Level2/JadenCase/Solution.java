package Level2.JadenCase;

import java.util.*;

/*
 * Question : 
	JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
	문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
 * 
 * 
 * 	Solution : 1. 어렵진 않았던 문제
 * 			   2. 첫번째가 공백이면 first 뒤에는 무조건 첫번째 글자가 올것이므로 boolean을 true로 변경
 * 			   3. 애초에 소문자로 만들어놓고 첫번째만 대문자로 만드는게 시간을 줄일 수 있음.
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