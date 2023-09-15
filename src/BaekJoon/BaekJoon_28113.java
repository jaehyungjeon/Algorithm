package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 숭실대학교 정보과학관은 숭실대입구역으로부터 멀리 떨어져 있는 대신, 바로 앞에 숭실대별관앞이라는 명칭의 버스 정류소가 자리 잡고 있다.

	학부 연구생 찬솔이는 야근을 마치고 대중교통을 이용해 집에 가려고 한다. 다행히 아슬아슬하게 막차가 끊기지 않은 상황인데, 구체적으로 
	$A$분 뒤에 숭실대별관앞 정류소에 집으로 가는 마지막 버스가 도착하고, 
	$B$분 뒤에 숭실대입구역에 집으로 가는 마지막 열차가 도착한다.
	
	찬솔이는 지금 버스 정류소에 서 있다. 그런데, 찬솔이는 지하철 역까지 걸어가서 지하철을 타는 것이 여기서 버스를 타는 것 보다 빠를 수도 있다는 사실을 알아차려 버렸다. 숭실대입구역의 지하철 승강장까지 걸어가는데는 
	$N$분이 걸린다. 버스와 지하철 중 더 먼저 탈 수 있는 것이 무엇인지 알려줘서 야근한 찬솔이의 피로를 회복시켜 주자.
	
	단, 버스와 지하철이 도착한 뒤 탑승하는 데 걸리는 시간은 신경 쓰지 않고, 버스와 지하철 모두 도착한 직후에 승객을 태운 뒤 기다리지 않고 바로 떠난다. 
	또한 지하철 역에 도착하는 시간과 지하철 열차가 도착하는 시간이 정확히 같다면 지하철을 탈 수 있다.

	input			 
	10 5 15
	
	output
	Bus
	
	Solution : 1. 단순 조건 비교 
	
*/

public class BaekJoon_28113 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		if(A < B) {
			System.out.println("Bus");
		} else if(A > B) {
			System.out.println("Subway");
		} else {
			System.out.println("Anything");
		}
	}

}
