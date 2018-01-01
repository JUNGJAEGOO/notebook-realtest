package back14612;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<node> list =new ArrayList<>();
		
		for ( int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String command = st.nextToken();
			if ( command.equals("order") ) {
				int table = Integer.parseInt(st.nextToken());
				int ordertime = Integer.parseInt(st.nextToken());
				list.add(new node(table,ordertime));
				
				for (int j = 0 ; j < list.size() ;j++) {
					System.out.print(list.get(j).table+" ");
					if ( j == list.size() - 1) {
						System.out.println();
					}
				}
			
			}else if ( command.equals("sort") ) {
				Collections.sort(list);
				
				for (int j = 0 ; j <  list.size() ; j++) {
					System.out.print(list.get(j).table+" ");
					if ( j == list.size() - 1) {
						System.out.println();
					}
				}
				
			}else {
				int deletetable = Integer.parseInt(st.nextToken());
				for ( int j = 0 ; j < list.size() ; j++) {
					if ( list.get(j).table == deletetable) {
						list.remove(j);
						break;
					}
				}
				
				for ( int j = 0 ; j < list.size() ;j++ ) {
					System.out.print(list.get(j).table+" ");
					if ( j == list.size() - 1) {
						System.out.println();
					}
				}
				
			}
			
			if ( list.size() == 0) {
				System.out.println("sleep");
			}
		}
	}
	
	public static class node implements Comparable<node> {
		int table;
		int order;
		node(int table,int order) {
			this.table = table;
			this.order = order;
		}
		@Override
		public int compareTo(node o) {
			
			if ( this.order > o.order) {
				return 1;
			}else if ( this.order == o.order ){
				if ( this.table > o.table ) {
					return 1;
				}else {
					return -1;
				}
			}else {
				return -1;
			}
		}
		



	}
	

}
