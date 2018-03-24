package back2456;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int sum[] = new int[3];
		int one[] = new int[3];
		int two[] = new int[3];
		int three[] = new int[3];
		
		for ( int i = 0 ; i < N ; i++) {
			int o = in.nextInt();
			int tw = in.nextInt();
			int th = in.nextInt();
			
			sum[0] += o;
			sum[1] += tw;
			sum[2] += th;
			
			if ( o == 3) {
				three[0]++;
			}else if ( o == 2) {
				two[0]++;
			}else {
				one[0]++;
			}
			
			
			if ( tw == 3) {
				three[1]++;
			}else if ( tw == 2) {
				two[1]++;
			}else {
				one[1]++;
			}
			
			if ( th == 3) {
				three[2]++;
			}else if ( th == 2) {
				two[2]++;
			}else {
				one[2]++;
			}
		}
		
		if ( sum[0] > sum[1] && sum[0] > sum[2]) {
			System.out.println(1+" "+sum[0]);
			return;
		}
		
		if ( sum[1] > sum[0] && sum[1] > sum[2]) {
			System.out.println(2+" "+sum[1]);
			return;
		}

		if ( sum[2] > sum[1] && sum[2] > sum[0]) {
			System.out.println(3+" "+sum[2]);
			return;
		}
		
		if ( sum[0] == sum[1] && sum[0] > sum[2]) {
			if ( three[0] > three[1]) {
				System.out.println(1+" "+sum[0]);
				return;
			}
			if ( three[1] > three[0]) {
				System.out.println(2+" "+sum[1]);
				return;
			}
			if ( three[0] == three[1]) {
				if ( two[0] > two[1]) {
					System.out.println(1+" "+sum[0]);
					return;
				}
				if ( two[1] > two[0]) {
					System.out.println(2+" "+sum[1]);
					return;
				}
				if ( two[0] == two[1]) {
					System.out.println(0+" "+sum[0]);
					return;
				}
			}
		}
		
		if ( sum[0] == sum[2] && sum[0] > sum[1]) {
			if ( three[0] > three[2]) {
				System.out.println(1+" "+sum[0]);
				return;
			}
			if ( three[2] > three[0]) {
				System.out.println(3+" "+sum[2]);
				return;
			}
			if ( three[0] == three[2]) {
				if ( two[0] > two[2]) {
					System.out.println(1+" "+sum[0]);
					return;
				}
				if ( two[2] > two[0]) {
					System.out.println(3+" "+sum[2]);
					return;
				}
				if ( two[0] == two[2]) {
					System.out.println(0+" "+sum[0]);
					return;
				}
			}
		}

		if ( sum[2] == sum[1] && sum[1] > sum[0]) {
			if ( three[2] > three[1]) {
				System.out.println(3+" "+sum[2]);
				return;
			}
			if ( three[1] > three[2]) {
				System.out.println(2+" "+sum[1]);
				return;
			}
			if ( three[2] == three[1]) {
				if ( two[2] > two[1]) {
					System.out.println(3+" "+sum[2]);
					return;
				}
				if ( two[1] > two[2]) {
					System.out.println(2+" "+sum[1]);
					return;
				}
				if ( two[2] == two[1]) {
					System.out.println(0+" "+sum[1]);
					return;
				}
			}
		}
		
		if ( sum[0] == sum[1] && sum[1] == sum[2]) {
			
			if ( three[0] > three[2] && three[0] > three[1]) {
				System.out.println(1+" "+sum[0]);
				return;
			}
			if ( three[1] > three[2] && three[1] > three[0]) {
				System.out.println(2+" "+sum[1]);
				return;		
			}
			if ( three[2] > three[1] && three[2] > three[1]) {
				System.out.println(3+" "+sum[2]);
				return;
			}
			
			if ( three[0] == three[1] && three[1] == three[2]) {
				if ( two[0] > two[1] && two[0] > two[2] ) {
					System.out.println(1+" "+sum[0]);
					return;
				}
				if ( two[1] > two[0] && two[1] > two[2] ) {
					System.out.println(2+" "+sum[1]);
					return;
				}
				if ( two[2] > two[1] && two[2] > two[0] ) {
					System.out.println(3+" "+sum[2]);
					return;
				}
				
				System.out.println(0+" "+sum[0]);
				return;

			}
			
			if ( three[0] == three[1] && three[0] > three[2] ) {
				if ( two[0] > two[1] ) {
					System.out.println(1+" "+sum[0]);
					return;
				}
				if ( two[1] > two[0]) {
					System.out.println(2+" "+sum[1]);
					return;
				}
				
				System.out.println(0+" "+sum[0]);
				return;
				
			}
			
			if ( three[0] == three[2] && three[0] > three[1] ) {
				if ( two[0] > two[2] ) {
					System.out.println(1+" "+sum[0]);
					return;
				}
				if ( two[2] > two[0]) {
					System.out.println(3+" "+sum[2]);
					return;
				}
				
				System.out.println(0+" "+sum[0]);
				return;
				
			}
			
			if ( three[1] == three[2] && three[1] > three[0] ) {
				if ( two[2] > two[1] ) {
					System.out.println(3+" "+sum[2]);
					return;
				}
				if ( two[1] > two[2]) {
					System.out.println(2+" "+sum[1]);
					return;
				}
				
				System.out.println(0+" "+sum[1]);
				return;
				
			}
			
		}

	}
}
