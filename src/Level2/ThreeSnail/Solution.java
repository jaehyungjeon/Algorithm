package Level2.ThreeSnail;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	정수 n이 매개변수로 주어집니다. 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 
	첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * 	Solution : 1. 등차수열의 공식을 이용하는 문제 -> an = a1 + (n-1)d
 * 			   2. i가 같을경우에는 내려간다 -> 아래
 * 			   3. i가 1일 경우에는 같은 라인에서 오른쪽으로 이동한다 -> 가로
 * 			   4. i가 2일 경우에는 대각선으로 이동한다 -> 대각
 * 			   5. 진행하면서 카운트만큼 변수를 증가시킨다.
 * 			   6. answer 배열 초기화 후 값을 넣어 return
 * 
 * */

public class Solution {

    public int[] solution(int n) {
        int[] answer = {};
        int[][] arr = new int[n][n];
        int x = -1;
        int y = 0;
        int cnt = 0;
        for(int i=0; i<n; i++) {
        	for(int j=i; j<n; j++) {
        		if(i % 3 == 0) x++; // 아래
        		else if(i % 3 == 1) y++; // 오른쪽
        		else if(i % 3 == 2) { // 대각선
        			x--;
        			y--;
        		}
        		arr[x][y] = ++cnt;
        	}
        }
        
        answer = new int[cnt];
        int num = 0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(arr[i][j] == 0) break;
        		answer[num++] = arr[i][j];
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 4;
		System.out.println(sol.solution(n));
	}
}