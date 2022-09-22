package Level1.KeyPad;

/*
 * Question : 
	이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
	맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.
	
	엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
	왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
	오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
	가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
	4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
	순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * Solution : 1. * -> 10 / # -> 12로 셋팅 
 * 			  2. /3으로 할 경우, 0을 따로 조건처리 해줘야 하므로 그냥 값비교로 단순하게 실행
 * 			  3. 거리가 같을 경우, hand와 같은 것을 도출
 * 
 * */

public class Solution {

	public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int leftNum = 10;
        int rightNum = 12;
        
        for(int cpNum : numbers) {
        	if(cpNum == 3 || cpNum == 6 || cpNum == 9) {
        		sb.append("R");
    			rightNum = cpNum;
        	} else if(cpNum == 1 || cpNum == 4 || cpNum == 7) {
        		sb.append("L");
    			leftNum = cpNum;
        	} else {
        		if(cpNum == 0) cpNum = 11;
    			int leftdist = Math.abs(cpNum - leftNum)/3 + Math.abs(cpNum - leftNum)%3;
    			int rightdist = Math.abs(cpNum - rightNum)/3 + Math.abs(cpNum - rightNum)%3;
    			
    			if(leftdist > rightdist) {
    				sb.append("R");
    				rightNum = cpNum;
    			} else if(leftdist < rightdist) {
    				sb.append("L");
    				leftNum = cpNum;
    			} else {
    				if(hand.equals("right")) {
    					sb.append("R");
    					rightNum = cpNum;
    				} else {
    					sb.append("L");
    					leftNum = cpNum;
    				}
    			}
 
        	}
        }
        	
        answer = sb.toString();
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
    	String hand = "right";
		System.out.println(sol.solution(numbers, hand));
		System.err.println("LRLLLRLLRRL");
	}
}
