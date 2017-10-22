package back1014;
import java.util.*;
public class Main {

	static int mat[][];
	static ArrayList<Integer> adj[];
	static int N;
	static int M;
	static int A[];
	static int B[];
	
	public static void main (String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		A = new int[N];
		B = new int[N];
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				String tmp = in.nextLine();
				char tmpchar = tmp.charAt(0);
				int tmpint = -1;
				if ( tmpchar == '.') {
					tmpint = 1;
				}
				else if ( tmpchar =='x') {
					tmpint = 0;
				}
				mat[i][j] = tmpint;
				
			}
		}
		
		
		
	}
}
