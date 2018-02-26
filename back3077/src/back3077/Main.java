package back3077;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String arr[] =br.readLine().split(" ");
		String hyun[] = br.readLine().split(" ");
		
		HashMap<String,Integer> hm = new HashMap<>();
		
		for (int i = 0 ; i < arr.length ; i++) {
			hm.put(arr[i], i);
		}
		
		int ans = 0;
		
		for (int i = 0 ; i < arr.length ; i++) {
			for (int j = i+1 ; j < arr.length ; j++) {
				if ( hm.get(hyun[i]) < hm.get(hyun[j]))  {
					ans++;
				}
			}
		}
		
		
		
		System.out.println(ans+"/"+( (N*(N-1))/2 ));
	}
}
