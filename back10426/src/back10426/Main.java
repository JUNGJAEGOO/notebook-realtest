package back10426;

import java.text.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		
		int go = Integer.parseInt(info[1]);
		
		String ymd[] = info[0].split("-");
		
		int Y = Integer.parseInt(ymd[0]);
		int M = Integer.parseInt(ymd[1]);
		int D = Integer.parseInt(ymd[2]);
		
		ArrayList<Integer> yun = new ArrayList<>();
		
		for ( int i = 1900 ; i <= 2100 ; i++) {
			if ( i%4 == 0) {
				if ( i %100 != 0) {
					yun.add(i);
				}
				else if ( i % 400 == 0) {
					yun.add(i);
				}
			}
		}
		
		
		for (int i = 0 ; i < go-1 ; i++) {
			
			D++;
			if ( M == 1 && D > 31) {
				M++;
				D = 1;
			}else if ( M == 2 ) {
				
				if ( yun.contains(Y) ) {
					if ( D > 29) {
						M++; D = 1;
					}
				}else {
					if ( D > 28) {
						M++; D = 1;
					}
				}
				
			}else if ( M == 3 && D > 31) {
				M++; D = 1;
			}else if ( M == 4 && D > 30) {
				M++; D = 1;
			}else if ( M == 5 && D > 31) {
				M++; D = 1;
			}else if ( M == 6 && D > 30) {
				M++; D = 1;
			}else if ( M == 7 && D > 31) {
				M++; D = 1;
			}else if ( M == 8 && D > 31) {
				M++; D = 1;
			}else if ( M == 9 && D > 30) {
				M++; D = 1;
			}else if ( M == 10 && D > 31) {
				M++;
				D = 1;
			}else if ( M == 11 && D > 30) {
				M++;
				D = 1;
			}else if ( M == 12 && D > 31) {
				Y++;
				M = 1;
				D = 1;
			}
			
		}
		
		String m = "";
		if ( M < 10 ) {
			m += "0";
		}
		m += String.valueOf(M);
		
		String d = "";
		if ( D < 10 ) {
			d += "0";
		}
		d += String.valueOf(D);
		
		System.out.println(Y+"-"+m+"-"+d);
	}
}
