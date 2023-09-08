package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
	Question : DNA란 어떤 유전물질을 구성하는 분자이다. 이 DNA는 서로 다른 4가지의 뉴클레오티드로 이루어져 있다(Adenine, Thymine, Guanine, Cytosine). 
	우리는 어떤 DNA의 물질을 표현할 때, 이 DNA를 이루는 뉴클레오티드의 첫글자를 따서 표현한다. 
	만약에 Thymine-Adenine-Adenine-Cytosine-Thymine-Guanine-Cytosine-Cytosine-Guanine-Adenine-Thymine로 이루어진 DNA가 있다고 하면, 
	“TAACTGCCGAT”로 표현할 수 있다. 그리고 Hamming Distance란 길이가 같은 두 DNA가 있을 때, 각 위치의 뉴클오티드 문자가 다른 것의 개수이다. 
	만약에 “AGCAT"와 ”GGAAT"는 첫 번째 글자와 세 번째 글자가 다르므로 Hamming Distance는 2이다.

	우리가 할 일은 다음과 같다. N개의 길이 M인 DNA s1, s2, ..., sn가 주어져 있을 때 Hamming Distance의 합이 가장 작은 DNA s를 구하는 것이다. 
	즉, s와 s1의 Hamming Distance + s와 s2의 Hamming Distance + s와 s3의 Hamming Distance ... 의 합이 최소가 된다는 의미이다.
	
	input			 
	5 8
	TATGATAC
	TAAGCTAC
	AAAGATCC
	TGAGATAC
	TAAGATGT
	
	output
	TAAGATAC
	7
	
	Solution : 1. 리스트의 배열을 이용하는 것이 떠올랐다.
			   2. 열끼리의 비교를 통해 가장 많은 것을 담아주자.
			   3. 사전순 정렬을 안해서 한번 틀렸다.
			   4. 열부터 비교하면서 key, value를 잡아준 뒤, keyList로 한번 꾸리고 list를 조건에 맞춰 정렬한다.
			   5. 해밍코드의 최소는 결국 행에서 가장 빈출된 단어의 카운트를 제외하면 된다.
			   6. Character를 concat을 활용해 하나의 String으로 만든 뒤, for문 바깥에서 함께 출력해준다.

*/

public class BaekJoon_1969 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<char[]> list = new ArrayList<char[]>();
		for(int i=0; i<N; i++) {
			list.add(br.readLine().toCharArray());
		}
		
		int sum = 0;
		String str = "";
		for(int i=0; i<M; i++) {
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for(int j=0; j<N; j++) {
				map.put(list.get(j)[i], map.getOrDefault(list.get(j)[i], 0) + 1);
				
			}

			List<Character> charList = new ArrayList<Character>(map.keySet());
			Collections.sort(charList, (o1, o2) -> {
				if(map.get(o1).equals(map.get(o2))) {
					return o1.compareTo(o2);
				}
				return map.get(o2) - map.get(o1);
			});
			
			sum += (N - map.get(charList.get(0)));
			str = str.concat(String.valueOf(charList.get(0)));
		}
		
		System.out.println(str);
		System.out.println(sum);
	}

}
