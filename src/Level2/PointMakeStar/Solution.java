package Level2.PointMakeStar;

import java.util.*;

/*
 * Question : 
	Ax + By + C = 0으로 표현할 수 있는 n개의 직선이 주어질 때, 이 직선의 교점 중 정수 좌표에 별을 그리려 합니다.

	예를 들어, 다음과 같은 직선 5개를
	
	2x - y + 4 = 0
	-2x - y + 4 = 0
	-y + 1 = 0
	5x - 8y - 12 = 0
	5x + 8y + 12 = 0
	좌표 평면 위에 그리면 아래 그림과 같습니다.
	
	RisingStarGraphBox.jpg
	
	이때, 모든 교점의 좌표는 (4, 1), (4, -4), (-4, -4), (-4, 1), (0, 4), (1.5, 1.0), (2.1, -0.19), (0, -1.5), (-2.1, -0.19), (-1.5, 1.0)입니다.
	이 중 정수로만 표현되는 좌표는 (4, 1), (4, -4), (-4, -4), (-4, 1), (0, 4)입니다.
	
	만약 정수로 표현되는 교점에 별을 그리면 다음과 같습니다.
	
	위의 그림을 문자열로 나타낼 때, 별이 그려진 부분은 *, 빈 공간(격자선이 교차하는 지점)은 .으로 표현하면 다음과 같습니다.
	
	"..........."  
	".....*....."  
	"..........."  
	"..........."  
	".*.......*."  
	"..........."  
	"..........."  
	"..........."  
	"..........."  
	".*.......*."  
	"..........."  
	이때 격자판은 무한히 넓으니 모든 별을 포함하는 최소한의 크기만 나타내면 됩니다.
	
	따라서 정답은
	
	"....*...."  
	"........."  
	"........."  
	"*.......*"  
	"........."  
	"........."  
	"........."  
	"........."  
	"*.......*"  
	입니다.

	직선 A, B, C에 대한 정보가 담긴 배열 line이 매개변수로 주어집니다. 이때 모든 별을 포함하는 최소 사각형을 return 하도록 solution 함수를 완성해주세요.

	Ax + By + E = 0
	Cx + Dy + F = 0
	두 직선의 교점이 유일하게 존재할 경우, 그 교점은 다음과 같습니다.
	
	x = BF - ED / AD - BC, y = EC - AF / AD - BC
	
	또, AD - BC = 0인 경우 두 직선은 평행 또는 일치합니다.

 * 
 *  output : ["....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"]
 * 
 * 	Solution : 1. 인터넷 참고..
 * 			   2. 교점을 구하기 위해 x, y값을 구한다.(x가 0일때, y가 0일때 -> next의 상수, 번갈아가면서 세팅)
 * 			   3. 반올림하여 min, max값 재세팅
 * 			   4. 존재하는 것의 위치에 true
 * 			   5. StringBuilder를 활용하여 true일때 '*', 없으면 '.'을 넣고 리턴
 * 
 * */

public class Solution {
	
    public String[] solution(int[][] line) {
        String[] answer = {};
        List<long[]> list = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        for(int i=0; i<line.length; i++) {
        	long a = line[i][0];
        	long b = line[i][1];
        	long e = line[i][2];
        	
        	for(int j=i+1; j<line.length; j++) {
        		long c = line[j][0];
        		long d = line[j][1];
        		long f = line[j][2];
        		
        		long xUp = b*f - e*d;
        		long xDown = a*d - b*c;
        		
        		long yUp = e*c - a*f;
        		long yDown = a*d - b*c;
        		
        		if(xDown != 0) {
        			double x = xUp / (double)xDown;
        			double y = yUp / (double)yDown;
        			
        			if(x == Math.ceil(x) && y == Math.ceil(y)) {
        				list.add(new long[] {(long)x, (long)y});
        				minX = Math.min(minX, (long)x);
        				maxX = Math.max(maxX, (long)x);
        				minY = Math.min(minY, (long)y);
        				maxY = Math.max(maxY, (long)y);
        			}
        		}
        	}
        }
        
        boolean[][] answerTemp = new boolean[(int)(maxY - minY + 1)][(int)(maxX - minX +1)];
        
        for(long[] vals : list) {
        	int x = (int)(vals[0] - minX);
        	int y = (int)(vals[1] - maxY);
        	
        	answerTemp[Math.abs(y)][Math.abs(x)] = true;
        }
        
        answer = new String[answerTemp.length];
        
        int i = 0;
        for(boolean[] bs : answerTemp) {
        	StringBuilder sb = new StringBuilder();
        	for(boolean b : bs) {
        		if(b) {
        			sb.append("*");
        		} else {
        			sb.append(".");
        		}
        	}
        	answer[i] = sb.toString();
        	i++;
        }

        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		System.out.println(sol.solution(line));
	}
}