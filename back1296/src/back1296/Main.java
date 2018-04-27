package back1296;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] minsik = in.nextLine().toCharArray();
		
		int minsikL = 0;
		int minsikO = 0;
		int minsikV = 0;
		int minsikE = 0;
		
		for ( int i = 0 ; i < minsik.length ; i++) {
			
			if ( minsik[i] == 'L') {
				minsikL++;
			}else if ( minsik[i] == 'O' ) {
				minsikO++;
			}else if ( minsik[i] == 'V' ) {
				minsikV++;
			}else if ( minsik[i] == 'E' ) {
				minsikE++;
			}
			
		}
		
		int N = Integer.parseInt(in.nextLine());
		
		int max = -100;
		ArrayList<String> maxName = new ArrayList<>();
		for ( int i = 0 ; i < N ; i++) {
			
			char[] girl = in.nextLine().toCharArray();
			
			int girlL = 0;
			int girlO = 0;
			int girlV = 0;
			int girlE = 0;
			
			
			for ( int j = 0 ; j < girl.length ; j++) {
				
				if ( girl[j] == 'L') {
					girlL++;
				}else if ( girl[j] == 'O' ) {
					girlO++;
				}else if ( girl[j] == 'V' ) {
					girlV++;
				}else if ( girl[j] == 'E' ) {
					girlE++;
				}
				
			}
			
			int sum = 0;
			int L = minsikL + girlL;
			int O = minsikO + girlO;
			int V = minsikV + girlV;
			int E = minsikE + girlE;
			sum = ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E)) % 100;
			if ( sum > max) {
				max = sum;
				maxName = new ArrayList<>();
				maxName.add(String.valueOf(girl));
			}else if( sum == max) {
				maxName.add(String.valueOf(girl));
			}
			
		}
		
		Collections.sort(maxName);
		System.out.println(maxName.get(0));
	}
}
