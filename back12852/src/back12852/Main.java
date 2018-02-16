package back12852;

import java.util.*;

public class Main {
	static int COUNT = 1000000000;
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(N);
		func(N,list,0);
		System.out.println(COUNT);
		for (int i = 0 ; i < ans.size() ; i++) {
			System.out.print(ans.get(i)+" ");
		}
		
	}
	
	public static void func(int N,ArrayList<Integer> list,int cnt) {
		
		if ( cnt > COUNT) {
			return;
		}
		
		if ( N == 1) {
			if ( cnt < COUNT) {
				COUNT = cnt;
				ans = (ArrayList<Integer>) list.clone();
			}
			return;
		}
		
		if ( N%3 == 0) {
			list.add(N/3);
			func(N/3,list,cnt+1);
			list.remove(list.size()-1);
		}
		
		if ( N%2 == 0) {
			list.add(N/2);
			func(N/2,list,cnt+1);
			list.remove(list.size()-1);
		}
		
		list.add(N-1);
		func(N-1,list,cnt+1);
		list.remove(list.size()-1);
	}
}
