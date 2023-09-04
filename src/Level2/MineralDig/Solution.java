package Level2.MineralDig;

import java.util.*;

/*
 * Question : 마인은 곡괭이로 광산에서 광석을 캐려고 합니다. 마인은 다이아몬드 곡괭이, 철 곡괭이, 돌 곡괭이를 각각 0개에서 5개까지 가지고 있으며, 곡괭이로 광물을 캘 때는 피로도가 소모됩니다. 
			  각 곡괭이로 광물을 캘 때의 피로도는 아래 표와 같습니다.
			  예를 들어, 철 곡괭이는 다이아몬드를 캘 때 피로도 5가 소모되며, 철과 돌을 캘때는 피로도가 1씩 소모됩니다. 각 곡괭이는 종류에 상관없이 광물 5개를 캔 후에는 더 이상 사용할 수 없습니다.
			  마인은 다음과 같은 규칙을 지키면서 최소한의 피로도로 광물을 캐려고 합니다.

			  사용할 수 있는 곡괭이중 아무거나 하나를 선택해 광물을 캡니다.
			  한 번 사용하기 시작한 곡괭이는 사용할 수 없을 때까지 사용합니다.
			  광물은 주어진 순서대로만 캘 수 있습니다.
			  광산에 있는 모든 광물을 캐거나, 더 사용할 곡괭이가 없을 때까지 광물을 캡니다.
			  즉, 곡괭이를 하나 선택해서 광물 5개를 연속으로 캐고, 다음 곡괭이를 선택해서 광물 5개를 연속으로 캐는 과정을 반복하며, 더 사용할 곡괭이가 없거나 광산에 있는 모든 광물을 캘 때까지 과정을 반복하면 됩니다.

			  마인이 갖고 있는 곡괭이의 개수를 나타내는 정수 배열 picks와 광물들의 순서를 나타내는 문자열 배열 minerals가 매개변수로 주어질 때, 
			  마인이 작업을 끝내기까지 필요한 최소한의 피로도를 return 하는 solution 함수를 완성해주세요.
 * 
 * 	output : 12 (1 + 1 + 1 + 1 + 1 + 5 + 1 + 1) = 12
 * 	ouput2 : 50 (5 + 5 + 5 + 5 + 5 + 5 + 5 + 5 + 5 + 5 + X) = 50 
 * 
 * 	Solution : 1. 단순한 방식으로 접근하면.. 안되나보다..
 * 			   2. 인터넷 참조 (bfs)
 * 
 *  
 * 			    
 * */

public class Solution {
	 
//	public int solution(int[] picks, String[] minerals) {
//        int answer = 0;
//        int dia = picks[0] * 5;
//        int iron = picks[1] * 5;
//        int stone = picks[2] * 5;
//
//        for(String mine : minerals) {
//        	if(dia == 0 && iron == 0 && stone == 0) {
//        		break;
//        	} else {
//        		if(dia > 0) {
//        			answer += 1;
//        			dia--;
//        		} else {
//        			if(iron > 0) {
//        				if(mine == "diamond") {
//        					answer += 5;
//        				} else {
//        					answer += 1;
//        				}
//        				
//        				iron--;
//        			} else {
//        				if(mine == "stone") {
//        					answer += 1;
//        				} else {
//        					answer += 5;
//        				}
//        				
//        				stone--;
//        			}
//        		}
//        	}
//        }
//        
//        return answer;
//    }
	
	int[] bPicks;
	String[] bMinerals;
	private int answer;
	
	public int solution(int[] picks, String[] minerals) {
		answer = Integer.MAX_VALUE;
		bPicks = picks;
		bMinerals = minerals;

		bfs();

		return answer;
	}

	private void bfs() {
		Deque<Miner> dq = new ArrayDeque<Miner>();
		dq.add(new Miner(new int[] {bPicks[0], bPicks[1], bPicks[2]}, 0, 0));
		
		while(!dq.isEmpty()) {
			Miner miner = dq.poll();
			
			if((miner.pickaxs[0] == 0) && (miner.pickaxs[1] == 0) && (miner.pickaxs[2] == 0) || miner.mineralIdx == bMinerals.length) {
				answer = Math.min(answer, miner.fatigue);
				continue;
			}
			
			if(miner.fatigue >= answer) {
				continue;
			}
			
			for(int i=0; i<3; i++) {
				int[] next = new int[] {miner.pickaxs[0], miner.pickaxs[1], miner.pickaxs[2]};
				int tmp = next[i];
				if(tmp == 0) continue;
				
				next[i] -= 1;
				
				int nextIdx = miner.mineralIdx;
				int nextFtg = miner.fatigue;
				
				int limit = nextIdx + 5;
				
				for(; nextIdx < limit; nextIdx++) {
					if(nextIdx >= bMinerals.length) break;
					
					if(bMinerals[nextIdx].equals("diamond")) {
						nextFtg += Math.pow(5, i);
					} else if(i == 2 && bMinerals[nextIdx].equals("iron")) {
						nextFtg += 5;
					} else {
						nextFtg += 1;
					}
				}
				
				dq.add(new Miner(next, nextIdx, nextFtg));
			}
		}
	}
	
	class Miner {
		int[] pickaxs;
		int mineralIdx;
		int fatigue;

		public Miner(int[] pickaxs, int mineralIdx, int fatigue) {
			this.pickaxs = pickaxs;
			this.mineralIdx = mineralIdx;
			this.fatigue = fatigue;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] picks = {1, 3, 2};
//		int[] picks = {0, 1, 1};
		String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
//		String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
		System.out.println(sol.solution(picks, minerals));
	}
}