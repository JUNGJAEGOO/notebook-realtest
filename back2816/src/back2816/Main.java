package back2816;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		String arr[] = new String[N];
		
		int kbs1 = 0;
		int kbs2 = 0;
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextLine();
			if ( arr[i].equals("KBS1") ) {
				kbs1 = i;
			}
			if ( arr[i].equals("KBS2") ) {
				kbs2 = i;
			}
		}
		
		int now = 0;
		
		while ( true ) {
			if ( arr[0].equals("KBS1") && arr[1].equals("KBS2") ) {
				break;
			}
			
			if ( arr[0].equals("KBS1") ) {
				
				for ( int i = 0 ; i < N ; i++) {
					if ( arr[i].equals("KBS2") ){
							kbs2 = i;
					}
				}
					while ( now != kbs2 ) {
						now++;
						System.out.print(1);
					}
					
					while ( kbs2 != 1) {
						String tmp = arr[now];
						arr[now] = arr[now-1];
						arr[now-1] = tmp;
						now--;
						kbs2--;
						System.out.print(4);
					}
					
			}else {
				
				while ( now != kbs1) {
					now++;
					System.out.print(1);
				}
				
				while ( kbs1 != 0) {
					String tmp = arr[now];
					arr[now] = arr[now-1];
					arr[now-1] = tmp;
					now--;
					kbs1--;
					System.out.print(4);
				}
				
			}

		}
	
	}
}
