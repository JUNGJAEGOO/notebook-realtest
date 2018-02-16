package back12790;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0 ) {
			
			int hp = in.nextInt();
			int mp = in.nextInt();
			int atk = in.nextInt();
			int def = in.nextInt();
			
			int item_hp = in.nextInt();
			int item_mp = in.nextInt();
			int item_atk = in.nextInt();
			int item_def = in.nextInt();
			
			hp += item_hp;
			if ( hp < 1) {
				hp = 1;
			}
			mp += item_mp;
			if ( mp < 1 ) {
				mp = 1;
			}
			atk += item_atk;
			if ( atk < 0) {
				atk = 0;
			}
			def += item_def;
			System.out.println(hp+(5*mp)+(2*atk)+(2*def));
			
			T--;
		}
	}
}
