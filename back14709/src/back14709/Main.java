package back14709;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		ArrayList<Integer> adj[] = new ArrayList[6];
		
		for (int i = 1 ; i <= 5 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < N ; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adj[from].add(to);
			adj[to].add(from);
			
		}
		
		boolean pass1 = false;
		boolean pass2 = false;
		boolean pass3 = false;
		
		if ( adj[2].size() == 0 && adj[5].size() == 0) {
			if ( adj[1].size() == 2) {
				if ( adj[1].get(0) == 3 && adj[1].get(1) ==4) {
					pass1 = true;
				}else if (adj[1].get(0) == 4 && adj[1].get(1) == 3) {
					pass1 = true;
				}
			}
			if ( adj[3].size() == 2) {
				if ( adj[3].get(0) == 1 && adj[3].get(1) ==4) {
					pass2 = true;
				}else if (adj[3].get(0) == 4 && adj[3].get(1) == 1) {
					pass2 = true;
				}
			}
			if ( adj[4].size() == 2) {
				if ( adj[4].get(0) == 1 && adj[4].get(1) ==3) {
					pass3 = true;
				}else if (adj[4].get(0) == 3 && adj[4].get(1) == 1) {
					pass3 = true;
				}
			}
			
		}
		
		//System.out.println(pass1+","+pass2+","+pass3);
		if ( pass1 && pass2 && pass3) {
			System.out.println("Wa-pa-pa-pa-pa-pa-pow!");
		}else {
			System.out.println("Woof-meow-tweet-squeek");
		}
		
		
	}
}
