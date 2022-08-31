package Level2.Delivery;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	N개의 마을로 이루어진 나라가 있습니다. 이 나라의 각 마을에는 1부터 N까지의 번호가 각각 하나씩 부여되어 있습니다. 
	각 마을은 양방향으로 통행할 수 있는 도로로 연결되어 있는데, 서로 다른 마을 간에 이동할 때는 이 도로를 지나야 합니다. 도로를 지날 때 걸리는 시간은 도로별로 다릅니다. 
	현재 1번 마을에 있는 음식점에서 각 마을로 음식 배달을 하려고 합니다. 각 마을로부터 음식 주문을 받으려고 하는데, N개의 마을 중에서 K 시간 이하로 배달이 가능한 마을에서만 주문을 받으려고 합니다. 

	위 그림에서 1번 마을에 있는 음식점은 [1, 2, 4, 5] 번 마을까지는 3 이하의 시간에 배달할 수 있습니다. 
	그러나 3번 마을까지는 3시간 이내로 배달할 수 있는 경로가 없으므로 3번 마을에서는 주문을 받지 않습니다. 따라서 1번 마을에 있는 음식점이 배달 주문을 받을 수 있는 마을은 4개가 됩니다.
	마을의 개수 N, 각 마을을 연결하는 도로의 정보 road, 음식 배달이 가능한 시간 K가 매개변수로 주어질 때, 음식 주문을 받을 수 있는 마을의 개수를 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * 	Solution : 1. 모든 정점을 거치는 알고리즘 - 플로이드 와샬 알고리즘
 * 			   2. 먼저 정점을 담는 배열에 초기화 값을 넣어준다.
 * 			   3. 정점과 정점을 연결해주는 맵
 * 			   4. 새로운 다리가 기존에 있던 다리보다 크면 넘기고, 작으면 갱신한다.
 * 			   5. 플로이드 와샬을 이용해 map 값을 담는다.
 * 			   6. K보다 작으면 answer++;
 * 
 * */

public class Solution {

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int [N][N];
        
        // 초기화
        for(int i=0; i<map.length; i++) {
        	for(int j=0; j<map[0].length; j++) {
        		if (i==j) continue;
        		map[i][j] = 500001;
        	}
        }
        
        for(int[] dt : road) {
        	if(map[dt[0] - 1][dt[1] - 1] < dt[2]) continue;
        	
        	map[dt[0]-1][dt[1]-1] = dt[2];
        	map[dt[1]-1][dt[0]-1] = dt[2];
        }
        
        for(int i=0; i<map.length; i++) {
        	for(int j=0; j<map.length; j++) {
        		for(int k=0; k<map.length; k++) {
        			if(map[j][k] > map[j][i] + map[i][k])
                        map[j][k] = map[j][i] + map[i][k];
        		}
        	}
        }
        
        for(int i=0; i<map[0].length; i++) {
        	if (map[0][i] <= K) {
        		answer++;
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int N = 5;
		int [][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int K = 3;
		System.out.println(sol.solution(N, road, K));
	}
}