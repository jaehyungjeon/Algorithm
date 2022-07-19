package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Pokemon {

	public static int N, M;
	public static Map<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(sc.nextToken());
		M = Integer.parseInt(sc.nextToken());

		for(int i=0; i<N; i++) {
			String st = br.readLine();
			String num = Integer.toString(i+1);
			
			map.put(st, num);
			map.put(num, st);
		}
		
		for(int i=0; i<M; i++) {
			System.out.println(map.get(br.readLine()));
		}
	}
}
