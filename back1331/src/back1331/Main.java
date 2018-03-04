package back1331;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		boolean visit[][] = new boolean[6][6];
		String arr[] = new String[36];
		for (int i = 0 ; i < 36; i++) {
			arr[i] = in.nextLine();
		}
		
		int X[] = {-2,-2,2,2,-1,-1,1,1};
		int Y[] = {1,-1,1,-1,2,-2,2,-2};
		
		HashMap<String,Integer> hm = new HashMap<>();
		hm.put("A", 0);
		hm.put("B", 1);
		hm.put("C", 2);
		hm.put("D", 3);
		hm.put("E", 4);
		hm.put("F", 5);
		boolean pass = true;
		
		int nowX = 6 - Integer.parseInt(String.valueOf(arr[0].toCharArray()[1]));
		int nowY = hm.get(String.valueOf(arr[0].toCharArray()[0]));
		int startX = nowX;
		int startY = nowY;
		//System.out.println(nowX+" "+nowY);
		//visit[nowX][nowY] = true;
		
		for ( int i = 1 ; i < 36 ; i++) {
			
			char nowcom[] = arr[i].toCharArray();
			int x = 6 - Integer.parseInt(String.valueOf(nowcom[1]));
			int y = hm.get(String.valueOf(nowcom[0]));
			//System.out.println(x+" "+y);
			boolean minipass = false;
			
			for (int j = 0 ; j < 8 ; j++) {
				int nx = nowX + X[j];
				int ny = nowY + Y[j];
				//System.out.println("nx: "+nx+" ny: "+ny);
				if ( nx == x && ny == y) {
					minipass = true;
					break;
				}
			}
			
			if ( minipass == false) {
				pass = false;
				break;
			}
			
			if ( visit[x][y] == true) {
				pass = false;
				break;
			}
			visit[x][y] = true;
			nowX = x;
			nowY = y;
		}
		
		//System.out.println(nowX+" "+nowY);
		if ( pass ) {
			pass = false;
			for ( int i = 0 ; i < 8 ; i++) {
				int nx = nowX + X[i];
				int ny = nowY + Y[i];
				if ( nx == startX && ny == startY && visit[nx][ny] == false) {
					//System.out.println(nx+" "+ny);
					visit[nx][ny] = true;
					pass = true;
					break;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0 ; i < 6 ; i++) {
			for (int j = 0 ; j <6 ; j++) {
				if ( visit[i][j]) {
					sum++;
				}
			}
		}
		//System.out.println(sum);
		
		if ( pass && sum == 36 ) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}
		
	}
}
