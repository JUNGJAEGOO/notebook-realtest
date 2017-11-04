package back1007;

import java.util.*;

public class Main {
	static boolean visit[];
	static int A[];
	static int B[];
	static ArrayList<data> adj[];
	static int mat[][];
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int count = 0;
		double result = 1900000000;
		while ( count < T) {
			N = in.nextInt();
			visit = new boolean[N];
			adj = new ArrayList[N];
			mat = new int[N][2];
			
			ArrayList<data> node = new ArrayList<>();
			for ( int i = 0 ; i < N ; i++) {
			int x = in.nextInt() ;
			int y = in.nextInt() ;
			node.add(new data(x,y));
			}
			//System.out.println(node.get(0).x+" "+node.get(0).y);
			for( int i = 0 ; i < N ; i++) {
				
				adj[i] = new ArrayList<data>();
				for ( int j = 0 ; j < N ; j++) {
					if ( j == i ) {continue;}
					adj[i].add(node.get(j));
				}
				
				//for( int j = 0 ; j < adj[i].size() ; j++) {
				//System.out.println(adj[i].get(j).x+" "+adj[i].get(j).y+" ");
				//}
			}
			
			
			ArrayList<vec> al = new ArrayList();
			for ( int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < adj[i].size() ; j++){
				al.add(new vec(node.get(i).x - adj[i].get(j).x,node.get(i).y - adj[i].get(j).y));
				}
			}
			/*for ( int i =0 ; i < al.size() ; i++) {
				System.out.println(al.get(i).x+" "+al.get(i).y);
			}
			*/
			if( al.size() == 2) {
				result = Math.sqrt(Math.pow(al.get(0).x, 2)+Math.pow(al.get(0).y,2));
			}else {
			for ( int i = 0 ; i < al.size() ; i++) {
				for ( int j = i+1 ; j < al.size() ; j++) {
				
				double len =Math.sqrt(Math.pow(al.get(i).x+al.get(j).x,2)
						+Math.pow(al.get(i).y+al.get(j).y,2));
				//System.out.println(len);
				if ( result < 0) {
					result = len;
				}else {
				result = Math.min(result, len);
				}
				}
			}
			}
			/*for ( int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < adj[i].size() ; j++) {
				double length = Math.sqrt(Math.pow((node.get(i).x - adj[i].get(j).x),2)+
						Math.pow((node.get(i).y - adj[i].get(j).y),2));
				if ( result < 0 ) {
					result = length;
				}else {
				result = Math.min(result, length);
				}
				}
			}*/
			
			System.out.format("%.6f", result);
			System.out.println();
			count++;
		}
	}
	
	public static class data{
		int x;
		int y;
		data(int x , int y ){
			this.x = x;
			this.y = y ;
		}
	}
	
	public static class vec{
		int x,y;
		vec(int x , int y){
			this.x = x; this.y = y;
		}
	}

}
