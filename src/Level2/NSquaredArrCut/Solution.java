package Level2.NSquaredArrCut;

import java.util.*;

/*
 * Question : 
	정수 n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.

	n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
	i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
	1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
	1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
	새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
	정수 n, left, right가 매개변수로 주어집니다. 주어진 과정대로 만들어진 1차원 배열을 return 하도록 solution 함수를 완성해주세요.
 * 
 *  output : [3,2,2,3]
 * 
 * 	Solution : 1. 문제가 어렵지는 않았느나 타입의 변환때매 애를 먹은 문제
 * 			   2. 행렬에서 인덱스 ex) (1,0), (0,1), (1,1) 에는 같은 수가 들어가므로 row, col 중 가장 큰 수의 +1을 해주는게 포인트
 * 			   3. for문을 left, right만큼만 돌려서 수를 바로 배열에 담아 리턴
 * 
 * */

public class Solution {

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        
        int idx = 0;
        for(long i=left; i<=right; i++) {
        	long row = (int) i/n;
        	long col = (int) i%n;
        	answer[idx++] = Math.max((int)row, (int)col) + 1;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 3;
		long left = 2;
		long right = 5;
		System.out.println(sol.solution(n, left, right));
	}
}