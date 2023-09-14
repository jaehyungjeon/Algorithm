package BaekJoon;

import java.util.Scanner;

/*
	Question : 수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

	리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
	
	수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.
	
	수빈이가 지금 보고 있는 채널은 100번이다.
	
	input
	5457
	3
	6 7 8
	
	output
	6
	
	Solution : 1. 고장났을 경우 boolean을 true로 변환한다.
			   2. 완전탐색을 이용하여 전체 건수에 대해서 차에 대한 최솟값을 구하는 문제이다.
			   3. 고장났을 경우는 0을 리턴시키고 고장난 버튼이 아닐 경우에는 해당 값을 리턴해준다.
			   4. 누르는 횟수는 원하는 채널번호에서 현재 누른 값을 빼주고 길이를 합쳐주면 된다.
			   5. 조금 더 세분화하여 보아야 할 것 같다...

*/

public class BaekJoon_1107 {

    static boolean[] chk; // 고장난 버튼 체크, false면 고장 안난 거, true가 고장난 거
    static int ret, N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        chk = new boolean[10];

        for(int i = 0; i < M; i++)
            chk[sc.nextInt()] = true;

        ret = Math.abs(N - 100); // 100번부터 위아래 버튼으로만 갔을 때가 초기값
        dfs(0, 0);
        System.out.println(ret);
    }

    public static void dfs(int len, int cur) {
        if(len == 6)
            return;

        cur *= 10;
        for(int i = 0; i < 10; i++) {
            if(!chk[i]) {
                ret = Math.min(ret, Math.abs(N - (cur + i)) + len + 1);
                dfs(len + 1, cur + i);
            }
        }
    }
}
