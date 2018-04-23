package back6148;

import java.util.*;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int arr[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int M = in.nextInt();
		
		arr = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		
		ArrayList<Integer> tmp = new ArrayList<>();
		tmp.add(0);
		func(-1,tmp);
		
		//System.out.println(list.size());
		//System.out.println(list.get(0));
		//System.out.println(list.get(1));
		//System.out.println(list.get(2));
		
		int min = 1000000000;
		for ( int i = 1 ; i < list.size() ; i++) {
			//System.out.println(list.get(i).get(0));
			if ( list.get(i).get(0) >= M) {
				min = Math.min(min, list.get(i).get(0) - M);
			}
		}
		System.out.println(min);
	}
	
	public static void func(int idx,ArrayList<Integer> sum) {
		
		//System.out.println(visit);
		ArrayList<Integer> tmp = new ArrayList<>();
		tmp.addAll(sum);
		//System.out.println("now tmp is "+tmp);
		list.add(tmp);
		
		for ( int i = idx+1  ; i < N ; i++) {
			
			
			sum.set(0,sum.get(0)+arr[i]);
			//System.out.println("sum is "+(sum.get(0)+arr[i]) );
			func(i,sum);
			sum.set(0,sum.get(0)-arr[i]);
		}
	}
}
