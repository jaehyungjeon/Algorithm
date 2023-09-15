package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
	Question : Furiosa AI에서는 AI 연산에 최적화된 반도체인 WARBOY란 이름의 NPU(Neural Processing Unit)를 만들고 있다. NPU는 인공지능 모델의 학습 및 추론을 기존의 처리 유닛보다 훨씬 빠르게 할 수 있다.

	WARBOY는 글로벌 AI 반도체 벤치마크 대회의 이미지 분류, 객체 검출 처리 속도 면에서 가장 좋은 성적을 받았다. 특히, WARBOY는 가격 대비 성능이 경쟁사 제품의 3배나 되어 많은 관심을 끌었다.
	
	가격 대비 성능은 아래와 같은 수식으로 계산된다.
	
	 가격대비성능
	성능
	가격
	 
	\[ \text{가격 대비 성능} = \frac{\text{성능}}{\text{가격}} \] 
	
	경쟁사 제품의 가격 
	$A$, 경쟁사 제품의 성능 
	$B$, WARBOY의 가격 
	$C$가 주어질 때, WARBOY의 성능을 구해보자.

	input			 
	10 100 7
	
	output
	210
	
	Solution : 1. (B/A) * C * 3
	
*/

public class BaekJoon_26082 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger A = new BigInteger(st.nextToken());
		BigInteger B = new BigInteger(st.nextToken());
		BigInteger C = new BigInteger(st.nextToken());
		
		System.out.println(B.divide(A).multiply(C).multiply(new BigInteger("3")));
	}

}
