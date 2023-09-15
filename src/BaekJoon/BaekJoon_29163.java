package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : Недавно Мистер Бин возвращался домой c конференции посвященной 2015 году --- году света и обнаружил, 
	что хулиганы исписали его дверь разными числами.

	Мистер Бин любит искать во всем позитив, и в этой ситуации он не растерялся. Дело в том, что Бин очень любит четные числа, 
	но при этом ненавидит нечетные. Поэтому он очень обрадуется, если четных чисел на двери написано больше чем нечетных. Иначе Мистер Бин расстроится.
	
	Ваша задача определить настроение Мистера Бина, если вам известно какие числа напсаны на его двери.

	input			 
	3
	1 2 1
	
	output
	Sad
	
	Solution : 1. 홀수가 짝수보다 많거나 같으면 Sad, 아니면 Happy
	
*/

public class BaekJoon_29163 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int evenCount = 0;
		for(int i=0; i<N; i++) {
			if(Integer.parseInt(st.nextToken()) % 2 == 1) {
				evenCount++;
			}
		}
		
		if(evenCount >= (N - evenCount)) {
			System.out.println("Sad");
		} else {
			System.out.println("Happy");
		}
	}

}
