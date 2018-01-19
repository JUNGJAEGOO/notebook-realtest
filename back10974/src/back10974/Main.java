package back10974;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class Main {
	static int N;
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		visit = new boolean[N];
		int arr[] = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = i+1;
		}
		
		perm(arr,0);
		System.out.println(sb);
	}
	
	public static void perm(int arr[],int len) {
		
		if ( len == N) {
			
			for (int i = 0 ; i < N ; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			
			
		}else {
			for (int i = 0 ; i< N ; ++i) {
				if ( visit[i] == false)
				{
					arr[len] = i+1;
					visit[i] = true;
					perm(arr,len+1);
					visit[i] = false;
				}
			}
			
		}
		
	}
	
	public static void swap(int arr[],int n,int d) {
		int temp = arr[n];
		arr[n] = arr[d];
		arr[d] = temp;
	}
}
