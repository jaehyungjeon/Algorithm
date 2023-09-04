package Level2.CuttingRollcake;

import java.util.*;

/*
 * Question : 
	철수는 롤케이크를 두 조각으로 잘라서 동생과 한 조각씩 나눠 먹으려고 합니다. 이 롤케이크에는 여러가지 토핑들이 일렬로 올려져 있습니다. 
	철수와 동생은 롤케이크를 공평하게 나눠먹으려 하는데, 그들은 롤케이크의 크기보다 롤케이크 위에 올려진 토핑들의 종류에 더 관심이 많습니다. 
	그래서 잘린 조각들의 크기와 올려진 토핑의 개수에 상관없이 각 조각에 동일한 가짓수의 토핑이 올라가면 공평하게 롤케이크가 나누어진 것으로 생각합니다.

	예를 들어, 롤케이크에 4가지 종류의 토핑이 올려져 있다고 합시다. 토핑들을 1, 2, 3, 4와 같이 번호로 표시했을 때, 케이크 위에 토핑들이 [1, 2, 1, 3, 1, 4, 1, 2] 순서로 올려져 있습니다. 
	만약 세 번째 토핑(1)과 네 번째 토핑(3) 사이를 자르면 롤케이크의 토핑은 [1, 2, 1], [3, 1, 4, 1, 2]로 나뉘게 됩니다. 
	철수가 [1, 2, 1]이 놓인 조각을, 동생이 [3, 1, 4, 1, 2]가 놓인 조각을 먹게 되면 철수는 두 가지 토핑(1, 2)을 맛볼 수 있지만, 
	동생은 네 가지 토핑(1, 2, 3, 4)을 맛볼 수 있으므로, 이는 공평하게 나누어진 것이 아닙니다. 
	만약 롤케이크의 네 번째 토핑(3)과 다섯 번째 토핑(1) 사이를 자르면 [1, 2, 1, 3], [1, 4, 1, 2]로 나뉘게 됩니다. 
	이 경우 철수는 세 가지 토핑(1, 2, 3)을, 동생도 세 가지 토핑(1, 2, 4)을 맛볼 수 있으므로, 이는 공평하게 나누어진 것입니다. 
	공평하게 롤케이크를 자르는 방법은 여러가지 일 수 있습니다. 위의 롤케이크를 [1, 2, 1, 3, 1], [4, 1, 2]으로 잘라도 공평하게 나뉩니다. 
	어떤 경우에는 롤케이크를 공평하게 나누지 못할 수도 있습니다.

	롤케이크에 올려진 토핑들의 번호를 저장한 정수 배열 topping이 매개변수로 주어질 때, 롤케이크를 공평하게 자르는 방법의 수를 return 하도록 solution 함수를 완성해주세요.
 * 
 *  output : 2
 * 
 * 	Solution : 1. Map과 Set을 이용하여 접근
 * 			   2. Map에 key에 맞는 value값을 담아줌
 * 			   3. 다시 for문 돌려서 앞서 Map에 담아뒀던 value를 하나씩 차감하고 set에 add
 * 			   4. Map의 값이 0이 되면 아예 삭제해서 중복담기 방지
 * 			   5. 같으면 answer++ 해주고 초기는 0으로 세팅
 * 
 * */

public class Solution {

    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int t : topping) {
        	map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        for(int k : topping) {
        	map.put(k, map.get(k) - 1);
        	set.add(k);
        	if(map.get(k) == 0) {
        		map.remove(k);
        	}

        	if(map.size() == set.size()) answer++;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] topping = {1, 2, 3, 1, 4};
		System.out.println(sol.solution(topping));
	}
}