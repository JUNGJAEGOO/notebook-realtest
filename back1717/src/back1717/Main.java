package back1717;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		ArrayList<Integer> arr[] = new ArrayList[n+1];
		for ( int i = 0 ; i <= n ; i++) {
			arr[i] = new ArrayList<Integer>();
			arr[i].add(i);
		}
		for ( int i = 0 ; i < m ; i++) {
			int select = in.nextInt();
			int index1 = in.nextInt();
			int index2 = in.nextInt();
			
			if ( select == 0 && index1 == index2 ) {continue;}
			
			if ( select == 0) {
			ArrayList<Integer> tmplist;
			tmplist = arr[index1];
			for( int j = 0 ; j < arr[index2].size();j++) {
			tmplist.add(arr[index2].get(j));
			}
			arr[index1] = tmplist;
			arr[index2] = tmplist;
			/*System.out.println(arr[index1]);
			System.out.println(arr[index2]);
			System.out.println(tmplist);*/
			}
			else if ( select == 1) {
				boolean check = false;
				for( int k = 0 ; k < arr[index1].size() ; k++) {
					if ( arr[index1].get(k) == index2) {
						check= true; break;
					}
				}
				if ( check == true) { System.out.println("YES");}
				else { System.out.println("NO");
				}
			}
		}
	}
}
