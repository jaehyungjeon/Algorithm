package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 고려대학교에는 정보보호학부가 있고, 정보보호학부에는 사이버국방학과와 스마트보안학과의 두 학과가 있다.

	공식 명칭은 학부와 학과 이름 모두 스마트보안학과이지만, 헷갈리는 관계로 모두가 편의상 정보보호학부, 스마트보안학과로 부른다.
	
	학부와 각 학과에는 2023년 8월 기준 아래와 같이 각 학부 혹은 학과 소속 동아리가 존재하며, 각 동아리의 목록과 소개는 아래와 같다. 소개는 각 동아리의 회장 혹은 임원에게 직접 받았으며, 보안상의 이유로 모자이크 처리했다.
	
	올해 1학기, 23학번 새내기로 입학한 민재는 이렇게 많은 동아리를 보고 감탄하며 가입하고자 하는 동아리를 정했다. 
	실제로는 모든 동아리에 중복으로 가입할 수 있지만, 아직 새내기였던 민재는 그 사실을 모른 채 하나의 동아리만 가입해야 하는지 알고, 마음속으로 하나를 정했다. 
	그러던 중 선배인 주영이와 밥약(선배가 후배에게 밥을 사주는 고대의 문화)을 하다가 동아리 얘기가 나왔고, 주영이는 민재에게 어떤 동아리에 가입하고 싶은지 물어보았다.

	민재는 답을 하려는 순간 동아리의 전체 이름이 기억나지 않고 첫 번째 글자 하나만 기억났다. 다행히 주영이는 이미 20학번 4학년이기 때문에 한 글자만 들어도 어떤 동아리인지 알 수 있다. 
	민재가 동아리의 첫번째 글자를 얘기할 때, 주영이가 되어 민재가 생각하고 있는 동아리의 전체 이름을 말해보자.

	input			 
	M
	
	output
	MatKor
	
	Solution : 1. swtich - case 문 사용.
	
*/

public class BaekJoon_28691 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		switch (str) {
			case "M" :
				System.out.println("MatKor");
				break;
			case "W" :
				System.out.println("WiCys");
				break;
			case "C" :
				System.out.println("CyKor");
				break;
			case "A" :
				System.out.println("AlKor");
				break;
			case "$" :
				System.out.println("$clear");
				break;
			default:
				break;
		}
	}

}
