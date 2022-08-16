package Level2.Carpet;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
	
	carpet.png
	
	Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
	
	Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * 
 * 	Solution : 1. height는 최소 3부터 시작-> 사이에 yellow가 껴있으려면 최소 3개는 있어야함
 * 			   2. 높이는 합계의 제곱근까지만 받음 -> 넘어가면 height > width 역전현상
 * 			   3. 포인트는 (height-2) * (width-2) 부분 -> 박스에서 가로가 2개, 세로가 2개 더 많기 때문
 * 
 * */

public class Solution {

    public int[] solution(int brown, int yellow) {
    	int[] answer = {};
        
        int sum = brown + yellow;
        int height = 0;
        int width = 0;
        
        for(height=3; height<=(int)Math.sqrt(sum); height++) {
        	if(sum % height == 0) {
        		width = sum/height;
        		
        		if((height-2) * (width-2) == yellow) {
        			answer = new int[] {width, height};
        		}
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int brown = 10;
		int yellow = 2;
		System.out.println(sol.solution(brown, yellow));
	}
}