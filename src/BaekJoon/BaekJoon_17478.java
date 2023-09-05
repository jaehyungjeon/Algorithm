package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 평소에 질문을 잘 받아주기로 유명한 중앙대학교의 JH 교수님은 학생들로부터 재귀함수가 무엇인지에 대하여 많은 질문을 받아왔다.

	매번 질문을 잘 받아주셨던 JH 교수님이지만 그는 중앙대학교가 자신과 맞는가에 대한 고민을 항상 해왔다.
	
	중앙대학교와 자신의 길이 맞지 않다고 생각한 JH 교수님은 결국 중앙대학교를 떠나기로 결정하였다.
	
	떠나기 전까지도 제자들을 생각하셨던 JH 교수님은 재귀함수가 무엇인지 물어보는 학생들을 위한 작은 선물로 자동 응답 챗봇을 준비하기로 했다.
	
	JH 교수님이 만들 챗봇의 응답을 출력하는 프로그램을 만들어보자.

	input			 
	2
	
	output
	어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.
	"재귀함수가 뭔가요?"
	"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
	마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
	그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
	____"재귀함수가 뭔가요?"
	____"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
	____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
	____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
	________"재귀함수가 뭔가요?"
	________"재귀함수는 자기 자신을 호출하는 함수라네"
	________라고 답변하였지.
	____라고 답변하였지.
	라고 답변하였지.
	
	Solution : 1. 재귀 호출하면서 append 해주는 방식.
			   2. 언더바를 넣는 부분을 따로 메소드로 따는게 핵심이었던 것 같다.

*/

public class BaekJoon_17478 {

	public static StringBuilder sb = new StringBuilder();
	public static int N;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		
		recursion(N);
		
		System.out.println(sb.toString());
	}
	
	private static void recursion(int M) {
		if(M == 0) { // 끝에 도달했을 경우
			sb.append(underBar(M)).append("\"재귀함수가 뭔가요?\"").append("\n");
			sb.append(underBar(M)).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
			sb.append(underBar(M)).append("라고 답변하였지.").append("\n");
			return;
		}
		
		sb.append(underBar(M)).append("\"재귀함수가 뭔가요?\"").append("\n");
		sb.append(underBar(M)).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
		sb.append(underBar(M)).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
		sb.append(underBar(M)).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");
		
		recursion(M-1);

		sb.append(underBar(M)).append("라고 답변하였지.").append("\n");
	}
	
	private static String underBar(int M) {
		String str = "";
		for(int i=0; i<(N-M)*4; i++) {
			str += "_";
		}
		
		return str; 
	}

}