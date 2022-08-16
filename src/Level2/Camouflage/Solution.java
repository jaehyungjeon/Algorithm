package Level2.Camouflage;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

	예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
	
	종류	이름
	얼굴	동그란 안경, 검정 선글라스
	상의	파란색 티셔츠
	하의	청바지
	겉옷	긴 코트
	스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 
 * 	Solution : 1. 종류의 경우의 수를 map에 담음
 * 			   2. key값(종류)에 따른 종류에 +1 후 계속해서 곱해주면, 모든 경우의 수
 * 			   3. 안입는 경우는 빼야 하기때문에 -1
 * 
 * */

public class Solution {

	public int solution(String[][] clothes) {
    	int answer = 1;
    	
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	for(String[] str : clothes) {
    		map.put(str[1], map.getOrDefault(str[1], 0) + 1);
    	}
    	
        Set<String> keySet = map.keySet();
        
        for(String key : keySet) {
        	answer *= map.get(key)+1; 
        }
    	
        return answer - 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(sol.solution(clothes));
	}
}