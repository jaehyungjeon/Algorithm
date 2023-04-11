package Level2.DiscountEvent;

import java.util.*;

/*
 * Question : XYZ 마트는 일정한 금액을 지불하면 10일 동안 회원 자격을 부여합니다. XYZ 마트에서는 회원을 대상으로 매일 한 가지 제품을 할인하는 행사를 합니다. 
			  할인하는 제품은 하루에 하나씩만 구매할 수 있습니다. 알뜰한 정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려 합니다.
			  예를 들어, 정현이가 원하는 제품이 바나나 3개, 사과 2개, 쌀 2개, 돼지고기 2개, 냄비 1개이며, XYZ 마트에서 15일간 회원을 대상으로 
			  할인하는 제품이 날짜 순서대로 치킨, 사과, 사과, 바나나, 쌀, 사과, 돼지고기, 바나나, 돼지고기, 쌀, 냄비, 바나나, 사과, 바나나인 경우에 대해 알아봅시다. 
			  첫째 날부터 열흘 간에는 냄비가 할인하지 않기 때문에 첫째 날에는 회원가입을 하지 않습니다. 
			  둘째 날부터 열흘 간에는 바나나를 원하는 만큼 할인구매할 수 없기 때문에 둘째 날에도 회원가입을 하지 않습니다. 
			  셋째 날, 넷째 날, 다섯째 날부터 각각 열흘은 원하는 제품과 수량이 일치하기 때문에 셋 중 하루에 회원가입을 하려 합니다.
			  정현이가 원하는 제품을 나타내는 문자열 배열 want와 정현이가 원하는 제품의 수량을 나타내는 정수 배열 number, 
			  XYZ 마트에서 할인하는 제품을 나타내는 문자열 배열 discount가 주어졌을 때, 회원등록시 정현이가 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수를 return 하는 solution 함수를 완성하시오. 
			  가능한 날이 없으면 0을 return 합니다.
	
 *	output : 3
 * 
 * 	Solution : 1. discount는 10일치까지만 계산하면 되니 전체 length에서 -9한 것만큼만 돌리면 됨 (0 ~ 9)
 * 			   2. Map에 제품별 10일치 카운트를 담는다.
 * 			   3. Map에 원하는 제품이 없거나 원하는 제품이 있을 경우 수량이 올바르지 않으면 false 처리 후 break 한다 -> 추가 동작 block
 * 			   4. true일 경우 값을 증가시킨다.
 * 
 * */

public class Solution {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i=0; i<discount.length - 9; i++) {
        	Map<String, Integer> map = new HashMap<String, Integer>();
        	for (int j=i; j<i+10; j++) {
        		map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
        	}

        	boolean check = false;
        	for(int k=0; k<want.length; k++) {
        		if(!map.containsKey(want[k]) || map.get(want[k]) != number[k]) {
        			check = false;
        			break;
        		} else {
        			check = true;
        		}
        	}
        	
        	if(check) answer++;
        }
        return answer;
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		System.out.println(sol.solution(want, number, discount));
	}
}