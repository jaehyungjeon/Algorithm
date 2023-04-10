package Level2.MandarinChoice;

import java.util.*;

/*
 * Question : 경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다. 
			  그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화하고 싶습니다.
			  예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다. 
			  경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.
			  경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다. 
			  경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 * 
 * 
 * 	Solution : 1. Map에 key에 따른 갯수를 담아준다.
 * 			   2. key만 담는 리스트를 하나 구성한다.
 * 			   3. value값 비교로 key를 내림차순으로 정렬한다.
 * 			   4. for문 돌리면서 map의 value값을 꺼내 전체 담을 갯수 k에서 차감시킨다.
 * 			   5. 0이하일 경우 for문을 빠져나온다.
 * 
 *  Caution : 1. map에 put할 때 map.get()으로 꺼내면 맵에서 다시 꺼내는 시간때문에 런타임 에러가 걸린다.
 *  		  2. 리스트의 sort 부분에서 compareTo를 사용할 경우 시간소요가 더 증가한다.
 * 			    
 * */

public class Solution {
	 
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int r : tangerine) {
        	map.put(r, map.getOrDefault(r, 0) + 1);
        }
        
        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        int i = 0;
        while(k > 0) {
        	k -= map.get(keyList.get(i));
        	answer++;
        	i++;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int k = 6;
		int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
		System.out.println(sol.solution(k, tangerine));
	}
}