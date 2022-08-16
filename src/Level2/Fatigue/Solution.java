package Level2.Fatigue;

import java.util.*;

/*
 * Question : 
	XX게임에는 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며, 일정 피로도를 사용해서 던전을 탐험할 수 있습니다. 
	이때, 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다. 
	"최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며, "소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다. 
	예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의 현재 남은 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모됩니다.

	이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다. 
	유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때, 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * 	Solution : 1. dfs를 이용한 풀이 - 모든 케이스를 비교해보겠다.
 * 			   2. dfs의 depth => 탐험할 수 있는 최대 던전 수
 * 			   3. k -> 피로도 이므로, 한번 돌고나면 2번째 배열의 값을 빼서 다시 dfs 돌린다.
 * 
 * */

public class Solution {

	public int answer = 0;
	public boolean[] visit;
	
    public int solution(int k, int[][] dungeons) {
    	visit = new boolean[dungeons.length];
    	
    	dfs(0, k, dungeons);
    	
        return answer;
    }
    
    public void dfs(int depth, int k, int[][] dungeons) {
    	for(int i=0; i<dungeons.length; i++) {
    		if(!visit[i] && dungeons[i][0] <= k) {
    			visit[i] = true;
    			dfs(depth + 1, k - dungeons[i][1], dungeons);
    			visit[i] = false;
    		}
    	}
    	
    	answer = Math.max(answer, depth);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		System.out.println(sol.solution(k, dungeons));
	}
}