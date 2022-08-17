package Level2.BinaryChangeRepeat;

/*
 * Question : 
	0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.

	x의 모든 0을 제거합니다.
	x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
	예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.
	
	0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 
	이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * 	Solution : 1. [0] = 회차, [1] = 0 제거 갯수
 * 			   2. 모든 0을 제거하면서 카운트를 증가
 *   		   3. dfs 이용하면 쉬울듯..?
 *   		   4. Binary로 변환해서 1이 아닐경우까지 재귀동작
 * */

public class Solution {

	public static int num = 0;
	public static int count = 0;
	
	public int[] solution(String s) {
        int[] answer = {};
        
    	dfs(s);
    	
    	answer = new int[] {num, count};
        return answer;
    }
    
    public static void dfs(String s) {
    	String str = "";
    	num++;
    	
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i) == '0') {
    			count++;
    		} else {
    			str += s.charAt(i);
    		}
    	}
    	
    	int length = str.length();
    	String Binary = Integer.toBinaryString(length);
    	String LenStr = String.valueOf(Integer.parseInt(Binary, 2));
    	s = Binary; // 길이를 String으로
    	
	    if(!LenStr.equals("1")) {
	    	dfs(Binary);
	    }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String s = "110010101001";
		System.out.println(sol.solution(s));
	}
}