package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : 바로 어제 최백준 조교가 방 열쇠를 주머니에 넣은 채 깜빡하고 서울로 가 버리는 황당한 상황에 직면한 조교들은, 702호에 새로운 보안 시스템을 설치하기로 하였다. 
	이 보안 시스템은 열쇠가 아닌 암호로 동작하게 되어 있는 시스템이다.

	암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다. 
	또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다. 
	즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.
	
	새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다. 
	이 알파벳을 입수한 민식, 영식 형제는 조교들의 방에 침투하기 위해 암호를 추측해 보려고 한다. 
	C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.

	input			 
	4 6
	a t c i s w
	
	output
	acis
	acit
	aciw
	acst
	acsw
	actw
	aist
	aisw
	aitw
	astw
	cist
	cisw
	citw
	istw
	
	Solution : 1. 문제 보자마자 백트래킹을 생각했다.
			   2. 값을 하나의 리스트에 담고 오름차순을 실시한다. a부터 순차대로 뽑기 위함.
			   3. 백트래킹을 진행하면서 해당 depth가 N 즉, 만들고자 하는 길이에 도달할때까지 재귀를 돌린다.
			   4. 유효성 검사를 하는데, 모음과 자음의 기준을 판정시킨다. (contains를 활용하였다.)
			   5. 참이면 list에 담긴 값을 뽑아 하나의 String으로 변환시켜준다.
			   6. 백트래킹에서는 combine에 담았다가 빼는 과정을 반복하기 위하여 add와 remove를 반복적으로 수행시켜준다.
	
*/

public class BaekJoon_1759 {

	public static int N, M;
	public static List<String> moeum = Arrays.asList("a", "e", "i", "o", "u");
	public static List<String> list = new ArrayList<String>();
	public static List<String> combine = new ArrayList<String>();
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			list.add(st.nextToken());
		}
	
		// 오름차순 정렬
		Collections.sort(list);
		
		dfs(0, 0);
		
		System.out.println(sb.toString());
	}
	
	private static void dfs(int start, int depth) {
		if(N == depth) {
			if(validCheck()) {
				String str = "";
				for(String s : combine) {
					str = str.concat(s);
				}
				sb.append(str).append("\n");
			}
			return;
		}
		
		for(int i=start; i<M; i++) {
			combine.add(list.get(i));
			dfs(i+1, depth+1);
			combine.remove(list.get(i));
		}
	}
	
	private static boolean validCheck() {
		int mo = 0;
		int ja = 0;

		for(String str : combine) {
			if(moeum.contains(str)) {
				mo++;
			} else {
				ja++;
			}
		}
		
		if(mo >= 1 && ja >= 2) return true;
		return false;
	}
}
