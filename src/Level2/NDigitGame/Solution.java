package Level2.NDigitGame;

import java.util.*;

/*
 * Question : 
	튜브가 활동하는 코딩 동아리에서는 전통적으로 해오는 게임이 있다. 이 게임은 여러 사람이 둥글게 앉아서 숫자를 하나씩 차례대로 말하는 게임인데, 규칙은 다음과 같다.

	숫자를 0부터 시작해서 차례대로 말한다. 첫 번째 사람은 0, 두 번째 사람은 1, … 열 번째 사람은 9를 말한다.
	10 이상의 숫자부터는 한 자리씩 끊어서 말한다. 즉 열한 번째 사람은 10의 첫 자리인 1, 열두 번째 사람은 둘째 자리인 0을 말한다.
	이렇게 게임을 진행할 경우,
	0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, …
	순으로 숫자를 말하면 된다.
	
	한편 코딩 동아리 일원들은 컴퓨터를 다루는 사람답게 이진수로 이 게임을 진행하기도 하는데, 이 경우에는
	0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, …
	순으로 숫자를 말하면 된다.
	
	이진수로 진행하는 게임에 익숙해져 질려가던 사람들은 좀 더 난이도를 높이기 위해 이진법에서 십육진법까지 모든 진법으로 게임을 진행해보기로 했다. 
	숫자 게임이 익숙하지 않은 튜브는 게임에 져서 벌칙을 받는 굴욕을 피하기 위해, 자신이 말해야 하는 숫자를 스마트폰에 미리 출력해주는 프로그램을 만들려고 한다. 튜브의 프로그램을 구현하라.
	
	입력 형식
	진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.
 * 
 * 
 * 	Solution : 1. 16진법이면.. 0, 1, 2, ..., A, B, ..., F(15)  
 * 			   2. 02468ACE / 11111111
 *			   3. 13579BDF / 01234567 -> 10(16+0 = 16), 11(16+1 = 17) ... 이런식으로 주고받음
 * 			   4. 이해는 됐으나 구현이.. -> 인터넷 참고
 * 			   5. 간단하게 StringBuilder의 길이로 m명이서 구해야할 전체 단어의 수만큼 while문 동작
 * 			   6. 16진수로 구하는데, num++를 통해 자릿수를 계속적으로 진법변환 시켜줌
 * 			   7. 다음 for문으로 시작은 -1로 순서를 맞춰준 뒤(첫번째 사람이면 0부터 시작, 두번째 사람이면 1부터 시작..)
 * 			   8. m*t(16*2)의 길이만큼 돌리되, i+=m(0,2,4,...) 번째자리만큼 증폭
 * 			   9. 각 자리의 문자를 answer에 담은 뒤 UpperCase로 대문자 변환하여 리턴해준다.
 * 			   10. 아이디어적인 측면은 이해가 되었으나, 역시 구현의 이슈가 있었음 -> 후에 재반복 실시하면서 익혀야 할듯.
 * */

public class Solution {

    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        while(sb.length() < m*t) {
        	sb.append(Integer.toString(num++, n)); 
        }
        
        for(int i=p-1; i<m*t; i+=m) {
        	answer += sb.charAt(i);
        }
        
        return answer.toUpperCase();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 1;
		System.out.println(sol.solution(n, t, m, p));
	}
}