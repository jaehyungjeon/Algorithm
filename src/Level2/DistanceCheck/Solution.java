package Level2.DistanceCheck;

import java.util.*;

/*
 * Question : 
	개발자를 희망하는 죠르디가 카카오에 면접을 보러 왔습니다.

	코로나 바이러스 감염 예방을 위해 응시자들은 거리를 둬서 대기를 해야하는데 개발 직군 면접인 만큼
	아래와 같은 규칙으로 대기실에 거리를 두고 앉도록 안내하고 있습니다.
	
	대기실은 5개이며, 각 대기실은 5x5 크기입니다.
	거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
	단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.
	예를 들어,
	
	5개의 대기실을 본 죠르디는 각 대기실에서 응시자들이 거리두기를 잘 기키고 있는지 알고 싶어졌습니다. 
	자리에 앉아있는 응시자들의 정보와 대기실 구조를 대기실별로 담은 2차원 문자열 배열 places가 매개변수로 주어집니다. 
	각 대기실별로 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
	
	Rule : 응시자가 앉아있는 자리(P)를 의미합니다. 빈 테이블(O)을 의미합니다. 파티션(X)을 의미합니다.
 * 
 * 	Solution : 1. 한칸을 사이에 두고, X로 구분되지 않을 시 0을 리턴
 *			   2. 범위로 보았을 때 BFS알고리즘 이용해야 할 듯.
 *			   3. BFS의 반복이기는 한데.. 조건들을 구하는 방법은 진짜 쉽지 않은듯
 *			   4. 거리2, 대각선을 구하는 공식은 많이 봐야할듯
 *			   5. 전체적으로 한번 더 묶는 것도 접근이 어려웠다고 봄 -> 36번째 라인
 * 
 * */

public class Solution {
	
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int t=0; t<places.length; t++) {
        	String[] tmp = places[t];
        	boolean check = false;
        	
	    	for(int i=0; i<places.length; i++) {
	        	for(int j=0; j<places[i].length; j++) {
	        		if(tmp[i].charAt(j) == 'P') {
	        			if(bfs(i, j, tmp)) {
	        				check = true;
	        				break;
	        			}
	        		}
	        	}
	        	if(check) {
	        		answer[t] = 0;
	        		break;
	        	}
	        }
	    	if(!check) {
	    		answer[t] = 1;
	    	}
        }
        
        return answer;
    }
    
    public static boolean bfs(int i, int j, String[] tmp) {
    	//상하좌우
    	int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    	
    	for(int[] d : dir) {
    		int nr = i + d[0];
    		int nc = j + d[1];
    		
    		if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
			if(tmp[nr].charAt(nc) == 'P') return true;
    	}
    	
    	// 거리 2
    	int[][] dir2 = new int[][]{{-2,0},{2,0},{0,-2},{0,2}};
    	for(int[] d : dir2) {
    		int nr = i + d[0];
    		int nc = j + d[1];
    		
    		if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
    		if(tmp[nr].charAt(nc) == 'P') {
    			if(tmp[(i+nr)/2].charAt((j+nc)/2) != 'X') {
    				return true;
    			}
    		}
    	}
    	
    	// 대각선
    	int[][] dir3 = new int[][]{{-1,-1},{-1,1},{1,-1},{1,1}};
    	for(int[] d : dir3) {
    		int nr = i + d[0];
    		int nc = j + d[1];
    		
    		if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
    		if(tmp[nr].charAt(nc) == 'P') {
    			if(!(tmp[i].charAt(nc) == 'X' && tmp[nr].charAt(j) == 'X')) {
    				return true;
    			}
    		}
    	}
    	
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(sol.solution(places));
	}
}