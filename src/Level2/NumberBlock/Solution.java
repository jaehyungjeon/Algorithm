package Level2.NumberBlock;

import java.util.*;

/*
 * Question : 
	그렙시에는 0으로 된 도로에 숫자 블록을 설치하기로 하였습니다. 숫자 블록의 규칙은 다음과 같습니다.

	블록의 번호가 n 일 때, 가장 처음 블록은 n * 2번째 위치에 설치합니다. 그다음은 n * 3, 그다음은 n * 4, ...로 진행합니다.만약 기존에 블록이 깔려있는 자리라면 그 블록을빼고 새로운 블록으로 집어넣습니다.
	
	예를 들어 1번 블록은 2,3,4,5, ... 인 위치에 우선 설치합니다. 그다음 2번 블록은 4,6,8,10, ... 인 위치에 설치하고, 3번 블록은 6,9,12... 인 위치에 설치합니다.
	
	이렇게 3번 블록까지 설치하고 나면 첫 10개의 블록은 0, 1, 1, 2, 1, 3, 1, 2, 3, 2이됩니다.
	
	그렙시는 길이가 1,000,000,000인 도로에 1번 블록부터 시작하여 10,000,000번 블록까지 위의 규칙으로 모두 놓았습니다.
	
	그렙시의 시장님은 특정 구간의 어떤 블록이 깔려 있는지 알고 싶습니다.
	
	구간을 나타내는 두 수 begin, end 가 매개변수로 주어 질 때, 그 구간에 깔려 있는 블록의 숫자 배열(리스트)을 return하는 solution 함수를 완성해 주세요.
 * 
 *  output : [0, 1, 1, 2, 1, 3, 1, 4, 3, 5]
 * 
 * 	Solution : 1. for문을 돌리면서 해당 지점에 제동을 걸 수 있는 boolean 값을 하나 셋팅한다.
 * 			   2. 숫자의 배치 조건이 자기자신을 제외한 n*2 부터 숫자 배치가 되기때문에 sqrt(제곱근)을 이용하여 1이상인 케이스까지 반복문을 돌릴 수 있도록 한다.
 * 			   3. 배열에 몫을 넣어주고 flag를 true로 변경하여 값이 범위를 넘지 않도록 한다.
 * 			   4. 돌리면서 false인 경우에는 1로 재셋팅한다. -> 0번째를 제외한 나머지는 1로 셋팅하기 때문
 * 			   5. 따라서, 변경되는 지점에만 flag = true 후 break, 아닌 경우에는 1로 셋팅
 * 
 * */

public class Solution {

    public int[] solution(long begin, long end) {
    	int Begin = (int)begin;
    	int End = (int)end;
        int[] answer = new int[End - Begin + 1];
        
        int idx = 0;
        for(int i=Begin; i<=End; i++) {
        	boolean flag = false;
        	
        	if(i == 1) {
        		answer[idx++] = 0;
        		continue;
        	}
        	
        	for(int j=2; j<=Math.sqrt(i); j++) {
                if (i % j == 0 && i / j <= 10000000) {
                    answer[idx++] = i/j;
                    flag = true;
                    break;
                }
        	}
        	
            if(!flag) answer[idx++] = 1;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		long begin = 1;
		long end = 10;
		System.out.println(sol.solution(begin, end));
	}
}