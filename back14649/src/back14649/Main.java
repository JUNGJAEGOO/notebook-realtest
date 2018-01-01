package back14649;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		node[] secretary = new node[N];
		char[] stone = new char[102];
		Arrays.fill(stone,'B');
		
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);
			secretary[i] = new node(start,direction);
		}
		
		boolean pass = false;
		while ( true ) {
			pass = false;
			for ( int i = 0 ; i < N ; i++) {
				if ( secretary[i].start > 0 && secretary[i].start < 101) {
					pass = true;
					if ( secretary[i].direction == 'L') {
						secretary[i].start--;
						if ( stone[secretary[i].start] == 'R') { 
							stone[secretary[i].start] = 'G';
						}else if ( stone[secretary[i].start] == 'G') {
							stone[secretary[i].start] = 'B';
						}else if ( stone[secretary[i].start] == 'B') {
							stone[secretary[i].start] = 'R'; 
						}
					}else {
						secretary[i].start++;
						if ( stone[secretary[i].start] == 'R') { 
							stone[secretary[i].start] = 'G';
						}else if ( stone[secretary[i].start] == 'G') {
							stone[secretary[i].start] = 'B';
						}else if ( stone[secretary[i].start] == 'B') {
							stone[secretary[i].start] = 'R'; 
						}
					}
				}
			}
			if ( pass == false ) {
				break;
			}
		}
		
		int r=0,g=0,b=0;
		for (int i = 1 ; i <= 100 ;i++) {
			//System.out.print(stone[i]);
			if ( stone[i] == 'R') {
				r++;
			}else if ( stone[i] == 'G') {
				g++;
			}else {
				b++;
			}
		}
		//System.out.println(b+","+r+","+g);
		double moon;
		moon = 0.01 * b * total;
		double hong = r * 0.01 * total;;
		double ahn =  g * 0.01 * total;;
		System.out.format("%.2f\n",moon);
		System.out.format("%.2f\n",hong);
		System.out.format("%.2f\n",ahn);
		
	}
	
	public static class node{
		int start;
		char direction;
		node(int start,char direction){
			this.start = start;
			this.direction  = direction;
		}
	}
}
