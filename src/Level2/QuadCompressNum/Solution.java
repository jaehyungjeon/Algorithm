package Level2.QuadCompressNum;

import java.util.*;

/*
 * Question : 
	0과 1로 이루어진 2n x 2n 크기의 2차원 정수 배열 arr이 있습니다. 당신은 이 arr을 쿼드 트리와 같은 방식으로 압축하고자 합니다. 구체적인 방식은 다음과 같습니다.

	당신이 압축하고자 하는 특정 영역을 S라고 정의합니다.
	만약 S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축시킵니다.
	그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역(입출력 예를 참고해주시기 바랍니다.)으로 쪼갠 뒤, 각 정사각형 영역에 대해 같은 방식의 압축을 시도합니다.
	arr이 매개변수로 주어집니다. 위와 같은 방식으로 arr을 압축했을 때, 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 * 
 * 	output : [10, 15]
 * 
 * 	Solution : 1. DP를 이용
 * 			   2. 크기가 1이면(압축 x) 해당 영역의 카운트 증가
 * 			   3. check를 통해 해당 지점부터 블록이 맞는지 평가
 * 			   4. 분할하여 재귀 반복(quad 재귀)
 * 
 * */

public class Solution {
	int[] answer;
	
    public int[] solution(int[][] arr) {
        answer = new int[2];
        
        quad(arr.length, 0, 0, arr);
        
        for(int a : answer) {
        	System.out.println(a);
        }
        
        return answer;
    }
    
    public void quad(int x, int y, int z, int[][] arr) {
    	if(x == 1) {
    		answer[arr[y][z]]++;
    		return;
    	}
    	
    	if(check(x, y, z, arr)) return;
    	
    	quad(x/2, y, z, arr);
    	quad(x/2, y + x/2, z, arr);
    	quad(x/2, y, z + x/2, arr);
    	quad(x/2, y + x/2, z + x/2, arr);
    }
    
    public boolean check(int x, int y, int z, int[][] arr) {
    	for(int i=y; i<y+x; i++) {
    		for(int j=z; j<z+x; j++) {
    			if(arr[y][z] != arr[i][j]) return false;
    		}
    	}
    	
    	answer[arr[y][z]]++;
    	return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
		System.out.println(sol.solution(arr));
	}
}