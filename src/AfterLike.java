import java.io.*;
import java.util.*;

public class AfterLike {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println("AfterLike?");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringBuilder sb = new StringBuilder();
			
			String input = br.readLine();
			
			String first = input.split("")[0].toUpperCase();
			String second = input.split("")[1].toUpperCase();
			
			if(first.equals("L") && second.equals("O")) {
				sb.append(first + second + "VE");
			} else if(first.equals("V") && second.equals("E")) {
				sb.append("LO" + first + second);
			} else {
				sb.append("아이브도 모르냐?");
			}
			
			bw.write(sb.toString());
			
			bw.flush();
			br.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
}
