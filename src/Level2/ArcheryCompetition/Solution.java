package Level2.ArcheryCompetition;

import java.util.*;

/*
 * Question : 
	카카오배 양궁대회가 열렸습니다.
	라이언은 저번 카카오배 양궁대회 우승자이고 이번 대회에도 결승전까지 올라왔습니다. 결승전 상대는 어피치입니다.
	카카오배 양궁대회 운영위원회는 한 선수의 연속 우승보다는 다양한 선수들이 양궁대회에서 우승하기를 원합니다. 
	따라서, 양궁대회 운영위원회는 결승전 규칙을 전 대회 우승자인 라이언에게 불리하게 다음과 같이 정했습니다.
	
	어피치가 화살 n발을 다 쏜 후에 라이언이 화살 n발을 쏩니다.
	점수를 계산합니다.
	과녁판은 아래 사진처럼 생겼으며 가장 작은 원의 과녁 점수는 10점이고 가장 큰 원의 바깥쪽은 과녁 점수가 0점입니다.
	만약, k(k는 1~10사이의 자연수)점을 어피치가 a발을 맞혔고 라이언이 b발을 맞혔을 경우 더 많은 화살을 k점에 맞힌 선수가 k 점을 가져갑니다. 
	단, a = b일 경우는 어피치가 k점을 가져갑니다. k점을 여러 발 맞혀도 k점 보다 많은 점수를 가져가는 게 아니고 k점만 가져가는 것을 유의하세요. 
	또한 a = b = 0 인 경우, 즉, 라이언과 어피치 모두 k점에 단 하나의 화살도 맞히지 못한 경우는 어느 누구도 k점을 가져가지 않습니다.
	
	예를 들어, 어피치가 10점을 2발 맞혔고 라이언도 10점을 2발 맞혔을 경우 어피치가 10점을 가져갑니다.
	다른 예로, 어피치가 10점을 0발 맞혔고 라이언이 10점을 2발 맞혔을 경우 라이언이 10점을 가져갑니다.
	모든 과녁 점수에 대하여 각 선수의 최종 점수를 계산합니다.
	
	최종 점수가 더 높은 선수를 우승자로 결정합니다. 단, 최종 점수가 같을 경우 어피치를 우승자로 결정합니다.
	현재 상황은 어피치가 화살 n발을 다 쏜 후이고 라이언이 화살을 쏠 차례입니다.
	라이언은 어피치를 가장 큰 점수 차이로 이기기 위해서 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지를 구하려고 합니다.
	
	화살의 개수를 담은 자연수 n, 어피치가 맞힌 과녁 점수의 개수를 10점부터 0점까지 순서대로 담은 정수 배열 info가 매개변수로 주어집니다. 
	이때, 라이언이 가장 큰 점수 차이로 우승하기 위해 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지를 10점부터 0점까지 순서대로 정수 배열에 담아 return 하도록 solution 함수를 완성해 주세요. 
	만약, 라이언이 우승할 수 없는 경우(무조건 지거나 비기는 경우)는 [-1]을 return 해주세요.
 * 
 *  output : [0,2,2,0,1,0,0,0,0,0,0]
 * 
 * 	Solution : 1. 10 ~ 0점까지 나열(총 11개의 info 배열)
 * 			   2. 온라인 소스 참고
 * 			   3. DFS를 활용한 문제이며 최초 접근은 어렵게 느껴졌으나.. 과정을 보면서 이해가 되지 않는 수준은 아니었음.
 * 			   4. ryan은 빈 배열로 세팅, apeach는 기존 info에서 가져오는 정보로 전역변수 설정을 해줌 -> dfs로 사용하기 위함(인자로 넘길 필요 없이 사용하기 위해서)
 * 			   5. DFS를 구성하는데, 10 ~ 0점까지의 11개의 배열에 ryan배열 값들을 증감시키며 재귀 호출
 * 			   6. DFS 진행하면서 depth를 계속해서 증가시켜 케이스를 늘림
 * 			   7. detph가 개수에 도달했을 때, apeach의 Sum값과 ryan의 Sum값을 비교함
 * 			   8. 둘 다 0인 경우는 0점으로 비긴케이스이므로 continue, apeach가 ryan의 값보다 크거나 같으면 apeach의 승리로 apSum증가, 그렇지 않을 경우는 ryan이 이긴것이므로 rySum증가
 * 			   9. rySum과 apSum의 차이를 max_diff로 비교하면서 max_diff보다 diff값이 크면 max_diff값을 변경하고 리스트 초기화를 진행한 뒤, ryan배열의 값을 새롭게 리스트에 넣어줌
 * 			  10. max_diff와 diff가 같으면 ryan의 배열값을 넣어주고 최종적으로 depth가 같으면 비교를 중지한 뒤 return으로 재귀를 종료시킴
 * 			  11. 다시 solution Method로 돌아와, max_diff가 -1이거나 즉, 값을 비교할 수 없는 상태이거나 max_diff가 0인 비겼을 경우인 케이스에는 -1을 배열로 리턴시킴
 * 			  12. Collections.sort를 내림차순으로 정렬하여 diff차이가 가장 큰 배열이 리스트의 앞으로 오게끔 정렬함
 * 			  13. 리스트의 첫번째 배열을 꺼내서 answer에 담아 return 시키면 됨.
 * 
 * */

public class Solution {
	
	public static List<int[]> list = new ArrayList<>();
	public static int max_diff = -1;
	public static int[] ryan;
	public static int[] apeach;
	
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        ryan = new int[info.length];
        apeach = info;

        dfs(n, 0, 0);
        if(max_diff == -1 || max_diff == 0) return new int[] {-1};
        
        Collections.sort(list, (o1, o2) -> {
        	for(int i=10; i>=0; i--) {
        		if(o1[i] != o2[i]) return o2[i] - o1[i];
        	}
        	return 0;
        });
        
        answer = list.get(0);
        
        return answer;
    }
    
    public static void dfs(int n, int depth, int start) {
    	if(n == depth) {
    		int apSum = 0;
    		int rySum = 0;
    		
    		for(int i=0; i<10; i++) {
    			if(apeach[i] == 0 && ryan[i] == 0) continue;
    			if(apeach[i] >= ryan[i]) apSum += (10-i);
    			else rySum += (10-i);
    		}
    		
    		for(int i=0; i<10; i++) {
    			int diff = rySum - apSum;
    			if(max_diff < diff) {
    				max_diff = diff;
    				list.clear();
    				list.add(ryan.clone());
    			} else if(max_diff == diff) {
    				list.add(ryan.clone());
    			}
    		}
    		
    		return;
    	}
    	
    	for(int i=start; i<apeach.length; i++) {
    		ryan[i]++;
    		dfs(n, depth+1, i);
    		ryan[i]--;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 5;
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		System.out.println(sol.solution(n, info));
	}
}