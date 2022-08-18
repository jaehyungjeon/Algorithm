package Level2.TowerOfHanoi;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	하노이 탑(Tower of Hanoi)은 퍼즐의 일종입니다. 세 개의 기둥과 이 기동에 꽂을 수 있는 크기가 다양한 원판들이 있고, 
	퍼즐을 시작하기 전에는 한 기둥에 원판들이 작은 것이 위에 있도록 순서대로 쌓여 있습니다. 
	게임의 목적은 다음 두 가지 조건을 만족시키면서, 한 기둥에 꽂힌 원판들을 그 순서 그대로 다른 기둥으로 옮겨서 다시 쌓는 것입니다.

	한 번에 하나의 원판만 옮길 수 있습니다.
	큰 원판이 작은 원판 위에 있어서는 안됩니다.
	하노이 탑의 세 개의 기둥을 왼쪽 부터 1번, 2번, 3번이라고 하겠습니다. 1번에는 n개의 원판이 있고 이 n개의 원판을 3번 원판으로 최소 횟수로 옮기려고 합니다.
	
	1번 기둥에 있는 원판의 개수 n이 매개변수로 주어질 때, n개의 원판을 3번 원판으로 최소로 옮기는 방법을 return하는 solution를 완성해주세요.
 * 
 * 
 * 	Solution : 1. 하노이의 탑은 재귀를 이용하여 구한다.
 * 			   2. A -> B로 가는 케이스, B -> C로 가는 케이스, A->C
 * 
 * */

public class Solution {

    public static List<int[]> list = new ArrayList<int[]>();
	
    public int[][] solution(int n) {
        Hanoi(n,1,2,3);
        int[][] answer = new int[list.size()][2];
        
        for(int i=0; i<list.size(); i++) {
        	answer[i][0] = list.get(i)[0];
        	answer[i][1] = list.get(i)[1];
        }
        
        return answer;
    }
    
	public static void Hanoi(int N, int start, int mid, int to) {
		int[] move = {start, to};
		
		if (N == 1) {
			// CASE 2 : 1 -> 3 들어옴
			list.add(move);
		} else {
			// A -> B (1 -> 2)
			Hanoi(N - 1, start, to, mid);
			
			// CASE 1 : 1 -> 2 들어옴, CASE 3 : 2 -> 3 들어옴  
			list.add(move);
	    
			// B -> C (2 -> 3)
			Hanoi(N - 1, mid, start, to);
		}
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 2;
		System.out.println(sol.solution(n));
	}
}