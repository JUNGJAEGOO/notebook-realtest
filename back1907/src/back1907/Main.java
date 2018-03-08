package back1907;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().split("=");
		
		//System.out.println(input[0]+" "+input[1]);
		String haha = "";
		for (int i = 0 ; i < input[0].length() ; i++) {
			haha += input[0].charAt(i);
		}
		//System.out.println(haha);
		String left[] = haha.split("\\+");
		
		int a = 1,b= 1,c=1;
		int aH = 0,aC = 0,aO = 0;
		int bH = 0,bC = 0,bO = 0;
		int cH = 0,cC = 0,cO = 0;
		
		Queue<Character> tmp = new LinkedList<>();
		for ( int i = 0 ; i < left[0].length() ; i++) {
			tmp.add(left[0].charAt(i));
		}
		
		char com = ' ';
		while ( !tmp.isEmpty() ) {
			
			char now = tmp.poll();
			//System.out.println(now);
			if( now == 'H') {
				aH++;
				com = 'H';
			}else if (now == 'C') {
				aC++;
				com = 'C';
			}else if (now == 'O') {
				aO++;
				com = 'O';
			}else {
				
				if ( com == 'H') {
					aH += Integer.parseInt(String.valueOf(now))-1;
				}else if ( com == 'C') {
					aC += Integer.parseInt(String.valueOf(now))-1;
				}else { 
					aO += Integer.parseInt(String.valueOf(now))-1;
				}
			}
		}

		
		tmp = new LinkedList<>();
		for ( int i = 0 ; i < left[1].length() ; i++) {
			tmp.add(left[1].charAt(i));
		}
		
		com = ' ';
		
		while ( !tmp.isEmpty() ) {
			
			char now = tmp.poll();
			
			if( now == 'H') {
				com = 'H';
				bH++;
			}else if (now == 'C') {
				com = 'C';
				bC++;
			}else if ( now == 'O') {
				com = 'O';
				bO++;
			}else {
				
				if ( com == 'H') {
					bH += Integer.parseInt(String.valueOf(now))-1;
				}else if ( com == 'C') {
					bC += Integer.parseInt(String.valueOf(now))-1;
				}else { 
					bO += Integer.parseInt(String.valueOf(now))-1;
				}
			}
		}

		
		
		tmp = new LinkedList<>();
		for ( int i = 0 ; i < input[1].length() ; i++) {
			tmp.add(input[1].charAt(i));
		}
		
		com = ' ';
		while ( !tmp.isEmpty() ) {
			
			char now = tmp.poll();
			
			if(now == 'H') {
				com = 'H';
				cH++;
			}else if (now == 'C') {
				com = 'C';
				cC++;
			}else if (now == 'O') {
				com = 'O';
				cO++;
			}else {

				if ( com == 'H') {
					cH += Integer.parseInt(String.valueOf(now))-1;
				}else if ( com == 'C') {
					cC += Integer.parseInt(String.valueOf(now))-1;
				}else { 
					cO += Integer.parseInt(String.valueOf(now))-1;
				}
			}
		}
		
		//System.out.println(aH+" "+aC+" "+aO);
		//System.out.println(bH+" "+bC+" "+bO);
	//	System.out.println(cH+" "+cC+" "+cO);
		
		lop:
		for (int i = 1 ; i<= 10 ; i++) {
			for (int j = 1 ; j<=10 ; j++) {
				for (int k =  1 ; k<=10 ; k++) {
					
					if ( i*aH + j*bH == k*cH && i*aC + j*bC == k*cC && i*aO + j*bO == k*cO ) {
						a = i; b = j; c= k;
						break lop;
					}
					
					
				}
			}
		}
		System.out.println(a+" "+b+" "+c);
	}
}
