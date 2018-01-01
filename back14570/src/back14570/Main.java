package back14570;

import java.io.*;
import java.util.*;

public class Main {
	static node[] tree = new node[200001];
	static long result = 1;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for ( int i = 1 ; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			tree[i] = new node();
			tree[i].num = i;
			tree[i].left = left;
			tree[i].right = right;
			
		}
		long K = Long.parseLong(br.readLine());
		
		good(1,K);
		
		System.out.println(result);
	}
	
	
	public static class node{
		int num;
		int left;
		int right;
		
		//1000000000000000000	
	}
	
	public static void good(int n,long k) {
		if ( k % 2 == 1) {
		if ( tree[n].left == -1 && tree[n].right == -1) {
			result = tree[n].num;
		}
		else if ( tree[n].left == -1) {
			good( tree[n].right,k);
		}else if (tree[n].right == -1) {
			good( tree[n].left,k);
		}else {
			
			good( tree[n].left, k/2 + 1);
			
		}
		}else {
			if ( tree[n].left == -1 && tree[n].right == -1) {
				result = tree[n].num;
			}
			else if ( tree[n].right == -1) {
				good(tree[n].left,k);
			}else if (tree[n].left == -1 ) {
				good(tree[n].right,k);
			}else {
				
				good(tree[n].right, k/2);
				
			}
		}
	}

}
