package back2668;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int arr[];
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		arr = new int[101];
		
		for ( int i = 1 ; i <= N ; i++) {
			arr[i] = in.nextInt();
		}
		
		ArrayList<Integer> list =new ArrayList<>();
		for ( int i = 1 ; i <= N;i++) {
			
			ArrayList<Integer> visit = new ArrayList<>();
			//visit.add(i);
			func(i,arr[i],visit);
			
		}
		
		System.out.println(ans.size());
		Collections.sort(ans);
		for ( int i = 0 ; i < ans.size(); i++ ) {
			System.out.println(ans.get(i));
		}
		
	}
	
	public static void func(int start,int now,ArrayList<Integer> visit) {
		
		//System.out.println(start+" "+now);
		
		if ( now == 0) {
			return;
		}
		
		if ( start != now && arr[now] == now) {
			return;
		}
		
		if ( start == now) {
			
			//System.out.println("hi"+visit);
			for ( int i = 0 ; i < visit.size() ; i++ ) {
				if ( !ans.contains(visit.get(i))) {
					ans.add(visit.get(i));
				}
			}
			if ( !ans.contains(start)) {
				ans.add(start);
			}
			
			return;
		}
			
		if ( !visit.contains(arr[now])) {
			visit.add(arr[now]);
			func(start,arr[now],visit);
		}
		
		
	}
}
