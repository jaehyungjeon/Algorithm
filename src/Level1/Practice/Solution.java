package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Question : 
	수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
	
	1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	
	1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * 	Solution : 1. 찍는 방식을 하드코딩 형식으로 배열에 담음
 * 			   2. 일치하는 것에 맞게 변수에다 카운트 증가시켜줌
 * 			   3. 정답률이 좋은 max값 뽑는다.
 * 			   4. 정수형 배열에 한번 담고 sort로 오름차순
 * 			   5. 리스트를 배열로 변환한 뒤 return
 * */

public class Solution {

	public List<Integer> num = new ArrayList<Integer>();
	
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int firstcount = 0;
        int secondcount = 0;
        int thirdcount = 0;
        
        int[] arr = new int[3];
        for(int i=0; i<answers.length; i++) {
        	if(answers[i] == first[i%5]) {
        		firstcount++;
        	}
        	
        	if(answers[i] == second[i%8]) {
        		secondcount++;
        	}
        	
        	if(answers[i] == third[i%10]) {
        		thirdcount++;
        	}
        	
        	arr[0] = firstcount;
        	arr[1] = secondcount;
        	arr[2] = thirdcount;
        }
        
        int maxValue = Math.max(Math.max(firstcount, secondcount), thirdcount);
        if(maxValue == firstcount) num.add(1);
        if(maxValue == secondcount) num.add(2);
        if(maxValue == thirdcount) num.add(3);
        
        Collections.sort(num);
        answer = num.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] answers = {1,3,2,4,2};
		System.out.println(sol.solution(answers));
	}
}
