package back13459;

import java.util.*;
import java.io.*;


public class Main {
	static char origin[][];
	static int rr,rc,br,bc;
	static int N,M;
	static boolean pass = false;
	public static void main(String args[]) throws IOException{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String input[] = buf.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		origin = new char[N][M];
		
		
		for (int i = 0 ; i < N ; i++) {
			char[] tmp = buf.readLine().toCharArray();
			for (int j = 0 ; j < M ; j++) {
				origin[i][j] = tmp[j];
				if ( origin[i][j] == 'R') {
					rr = i;
					rc = j;
				}else if ( origin[i][j] == 'B') {
					br = i;
					bc = j;
				}
				
			}
		}
		
		double a = System.currentTimeMillis();
		BFS();
		double b = System.currentTimeMillis();
		System.out.println(b-a);
		if ( pass ) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(origin.clone(),0,br,bc,rr,rc));
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			char mat[][] = now.mat;
			int cnt = now.cnt;
			int Br = now.Br;
			int Bc = now.Bc;
			int Rr = now.Rr;
			int Rc = now.Rc;
			if ( mat[Rr][Rc] == 'O' && mat[Br][Bc] == 'O') {
				continue;
			}
			if ( mat[Rr][Rc] == '.' && mat[Br][Bc] == 'O') {
				continue;
			}
			
			if ( mat[Rr][Rc] == 'O' && mat[Br][Bc] != 'O') {
				pass = true;
				return;
			}
			
			/*System.out.println(Rr+","+Rc+" "+Br+","+Bc);
			for (int i = 0 ; i < N ; i++ ) {
				for (int j = 0 ; j < N ; j++) {
					System.out.print(mat[i][j]);
				}
				System.out.println();
			}
			System.out.println();*/
			
			
			if ( cnt + 1 <= 10) {
				ArrayList<pack> tmp = new ArrayList<>();
				char upmat[][] = new char[N][M];
				//char downmat[][] = new char[N][M];
				//char leftmat[][] = new char[N][M];
				//char rightmat[][] = new char[N][M];
				for (int i = 0 ; i < N ; i++) {
					for (int j = 0 ; j < M ; j++) {
						upmat[i][j] = mat[i][j];
						//downmat[i][j] = mat[i][j];
						//leftmat[i][j] = mat[i][j];
						//rightmat[i][j] = mat[i][j];
					}
				}
				

				
				tmp = up(upmat,Br,Bc,Rr,Rc);
				if ( tmp.get(0).Bc == tmp.get(0).Rc && tmp.get(0).Br == tmp.get(0).Rr) {
				}else {
					q.add(new node(tmp.get(0).mat,cnt+1,tmp.get(0).Br,tmp.get(0).Bc,tmp.get(0).Rr,tmp.get(0).Rc));
				}
			
				tmp = new ArrayList<>();
				tmp = down(upmat,Br,Bc,Rr,Rc);
				if ( tmp.get(0).Bc == tmp.get(0).Rc && tmp.get(0).Br == tmp.get(0).Rr) {
				}else {
					q.add(new node(tmp.get(0).mat,cnt+1,tmp.get(0).Br,tmp.get(0).Bc,tmp.get(0).Rr,tmp.get(0).Rc));
				}
			
				
				tmp = new ArrayList<>();
				tmp = left(upmat,Br,Bc,Rr,Rc);
				if ( tmp.get(0).Bc == tmp.get(0).Rc && tmp.get(0).Br == tmp.get(0).Rr) {
				}else {
					q.add(new node(tmp.get(0).mat,cnt+1,tmp.get(0).Br,tmp.get(0).Bc,tmp.get(0).Rr,tmp.get(0).Rc));
				}
			
				
				tmp = new ArrayList<>();
				tmp = right(upmat,Br,Bc,Rr,Rc);
				if ( tmp.get(0).Bc == tmp.get(0).Rc && tmp.get(0).Br == tmp.get(0).Rr) {
				}else {
					q.add(new node(tmp.get(0).mat,cnt+1,tmp.get(0).Br,tmp.get(0).Bc,tmp.get(0).Rr,tmp.get(0).Rc));
				}
				
			}
			
		}
		
	}
	
	public static class pack{
		char mat[][];
		int Br,Bc;
		int Rr,Rc;
		pack(char mat[][],int Br,int Bc,int Rr,int Rc){
			this.Br = Br;
			this.Bc = Bc;
			this.Rr = Rr;
			this.Rc = Rc;
			this.mat = mat;
		}
	}
	
	public static class node{
		char mat[][];
		int cnt;
		int Br,Bc;
		int Rr,Rc;
		node ( char mat[][],int cnt,int Br,int Bc,int Rr,int Rc ){
			this.mat = mat;
			this.cnt = cnt;
			this.Br = Br;
			this.Bc = Bc;
			this.Rr = Rr;
			this.Rc = Rc;
		}
	}
	
	public static ArrayList<pack> up(char[][] mat,int Br,int Bc,int Rr,int Rc ) {
		
		if ( Bc == Rc) {
			if ( Br < Rr) {
				int cnt = 1;
				while ( true ) {
					if ( mat[Br-cnt][Bc] == '#' ) {
						mat[Br][Bc] = '.';
						Br = Br - cnt + 1;
						mat[Br][Bc] = 'B';
						break;
					}
					else if (  mat[Br-cnt][Bc] == 'O') {
						mat[Br][Bc] = '.';
						Br = Br - cnt;
						break;
					}
					cnt++;
				}
				
				cnt = 1;
				while ( true ) {
					if ( mat[Rr-cnt][Rc] == '#' || mat[Rr-cnt][Rc] == 'B'  ) {
						mat[Rr][Rc] = '.';
						Rr = Rr - cnt + 1;
						mat[Rr][Rc] = 'R';
						break;
					}
					else if (  mat[Rr-cnt][Rc] == 'O') {
						mat[Rr][Rc] = '.';
						Rr = Rr - cnt;
						break;
					}
					cnt++;
				}
			}else {
				
				int cnt = 1;
				while ( true ) {
					if ( mat[Rr-cnt][Rc] == '#' ) {
						mat[Rr][Rc] = '.';
						Rr = Rr - cnt + 1;
						mat[Rr][Rc] = 'R';
						break;
					}
					else if (  mat[Rr-cnt][Rc] == 'O') {
						mat[Rr][Rc] = '.';
						Rr = Rr - cnt;
						break;
					}
					cnt++;
				}
				
				cnt = 1;
				while ( true ) {
					if ( mat[Br-cnt][Bc] == '#' || mat[Br-cnt][Bc] == 'R'  ) {
						mat[Br][Bc] = '.';
						Br = Br - cnt + 1;
						mat[Br][Bc] = 'B';
						break;
					}
					else if (  mat[Br-cnt][Bc] == 'O') {
						mat[Br][Bc] = '.';
						Br = Br - cnt;
						break;
					}
					cnt++;
				}
			}
		}else {
			int cnt = 1;
			while ( true ) {
				if ( mat[Rr-cnt][Rc] == '#' ) {
					mat[Rr][Rc] = '.';
					Rr = Rr - cnt + 1;
					mat[Rr][Rc] = 'R';
					break;
				}
				else if (  mat[Rr-cnt][Rc] == 'O') {
					mat[Rr][Rc] = '.';
					Rr = Rr - cnt;
					break;
				}
				cnt++;
			}
			
			cnt = 1;
			while ( true ) {
				if ( mat[Br-cnt][Bc] == '#' ) {
					mat[Br][Bc] = '.';
					Br = Br - cnt + 1;
					mat[Br][Bc] = 'B';
					break;
				}
				else if (  mat[Br-cnt][Bc] == 'O') {
					mat[Br][Bc] = '.';
					Br = Br - cnt;
					break;
				}
				cnt++;
			}

		}
		
		ArrayList<pack> list = new ArrayList<>();
		list.add(new pack(mat,Br,Bc,Rr,Rc));
		return list;
	}
	
	public static ArrayList<pack> down(char[][] mat,int Br,int Bc,int Rr,int Rc ) {
		
		if ( Bc == Rc) {
			if ( Br > Rr) {
				int cnt = 1;
				while ( true ) {
					if ( mat[Br+cnt][Bc] == '#' ) {
						mat[Br][Bc] = '.';
						Br = Br + cnt - 1;
						mat[Br][Bc] = 'B';
						break;
					}
					else if (  mat[Br+cnt][Bc] == 'O') {
						mat[Br][Bc] = '.';
						Br = Br + cnt;
						break;
					}
					cnt++;
				}
				
				cnt = 1;
				while ( true ) {
					if ( mat[Rr+cnt][Rc] == '#' || mat[Rr+cnt][Rc] == 'B'  ) {
						mat[Rr][Rc] = '.';
						Rr = Rr + cnt - 1;
						mat[Rr][Rc] = 'R';
						break;
					}
					else if (  mat[Rr+cnt][Rc] == 'O') {
						mat[Rr][Rc] = '.';
						Rr = Rr + cnt;
						break;
					}
					cnt++;
				}
			}else {
				
				int cnt = 1;
				while ( true ) {
					if ( mat[Rr+cnt][Rc] == '#' ) {
						mat[Rr][Rc] = '.';
						Rr = Rr + cnt - 1;
						mat[Rr][Rc] = 'R';
						break;
					}
					else if (  mat[Rr+cnt][Rc] == 'O') {
						mat[Rr][Rc] = '.';
						Rr = Rr + cnt;
						break;
					}
					cnt++;
				}
				
				cnt = 1;
				while ( true ) {
					if ( mat[Br+cnt][Bc] == '#' || mat[Br+cnt][Bc] == 'R'  ) {
						mat[Br][Bc] = '.';
						Br = Br + cnt - 1;
						mat[Br][Bc] = 'B';
						break;
					}
					else if (  mat[Br+cnt][Bc] == 'O') {
						mat[Br][Bc] = '.';
						Br = Br + cnt;
						break;
					}
					cnt++;
				}
			}
		}else {
			int cnt = 1;
			while ( true ) {
				if ( mat[Rr+cnt][Rc] == '#' ) {
					mat[Rr][Rc] = '.';
					Rr = Rr + cnt - 1;
					mat[Rr][Rc] = 'R';
					break;
				}
				else if (  mat[Rr+cnt][Rc] == 'O') {
					mat[Rr][Rc] = '.';
					Rr = Rr + cnt;
					break;
				}
				cnt++;
			}
			
			cnt = 1;
			while ( true ) {
				if ( mat[Br+cnt][Bc] == '#' ) {
					mat[Br][Bc] = '.';
					Br = Br + cnt - 1;
					mat[Br][Bc] = 'B';
					break;
				}
				else if (  mat[Br+cnt][Bc] == 'O') {
					mat[Br][Bc] = '.';
					Br = Br + cnt;
					break;
				}
				cnt++;
			}
			
			
		}
		
		ArrayList<pack> list = new ArrayList<>();
		list.add(new pack(mat,Br,Bc,Rr,Rc));
		return list;
		
	}
	
	public static ArrayList<pack> left(char[][] mat,int Br,int Bc,int Rr,int Rc ) {
		
		if ( Br == Rr) {
			if ( Bc < Rc) {
				int cnt = 1;
				while ( true ) {
					if ( mat[Br][Bc-cnt] == '#' ) {
						mat[Br][Bc] = '.';
						Bc= Bc - cnt + 1;
						mat[Br][Bc] = 'B';
						break;
					}
					else if (  mat[Br][Bc-cnt] == 'O') {
						mat[Br][Bc] = '.';
						Bc = Bc - cnt;
						break;
					}
					cnt++;
				}
				
				cnt = 1;
				while ( true ) {
					if ( mat[Rr][Rc-cnt] == '#' || mat[Rr][Rc-cnt] == 'B'  ) {
						mat[Rr][Rc] = '.';
						Rc = Rc - cnt + 1;
						mat[Rr][Rc] = 'R';
						break;
					}
					else if (  mat[Rr][Rc-cnt] == 'O') {
						mat[Rr][Rc] = '.';
						Rc = Rc - cnt;
						break;
					}
					cnt++;
				}
			}else {
				
				int cnt = 1;
				while ( true ) {
					if ( mat[Rr][Rc-cnt] == '#'  ) {
						mat[Rr][Rc] = '.';
						Rc = Rc - cnt + 1;
						mat[Rr][Rc] = 'R';
						break;
					}
					else if (  mat[Rr][Rc-cnt] == 'O') {
						mat[Rr][Rc] = '.';
						Rc = Rc - cnt;
						break;
					}
					cnt++;
				}
				
				cnt = 1;
				while ( true ) {
					if ( mat[Br][Bc-cnt] == '#' || mat[Br][Bc-cnt] == 'R'  ) {
						mat[Br][Bc] = '.';
						Bc= Bc - cnt + 1;
						mat[Br][Bc] = 'B';
						break;
					}
					else if (  mat[Br][Bc-cnt] == 'O') {
						mat[Br][Bc] = '.';
						Bc = Bc - cnt;
						break;
					}
					cnt++;
				}
				
			}
		}else {
			
			int cnt = 1;
			while ( true ) {
				if ( mat[Rr][Rc-cnt] == '#' ) {
					mat[Rr][Rc] = '.';
					Rc = Rc - cnt + 1;
					mat[Rr][Rc] = 'R';
					break;
				}
				else if (  mat[Rr][Rc-cnt] == 'O') {
					mat[Rr][Rc] = '.';
					Rc = Rc - cnt;
					break;
				}
				cnt++;
			}
			
			cnt = 1;
			while ( true ) {
				if ( mat[Br][Bc-cnt] == '#' ) {
					mat[Br][Bc] = '.';
					Bc= Bc - cnt + 1;
					mat[Br][Bc] = 'B';
					break;
				}
				else if (  mat[Br][Bc-cnt] == 'O') {
					mat[Br][Bc] = '.';
					Bc = Bc - cnt;
					break;
				}
				cnt++;
			}
			
			
		}
		ArrayList<pack> list = new ArrayList<>();
		list.add(new pack(mat,Br,Bc,Rr,Rc));
		return list;
		
	}
	
	public static ArrayList<pack> right(char[][] mat,int Br,int Bc,int Rr,int Rc ) {
		
		if ( Br == Rr) {
			if ( Bc > Rc) {
				int cnt = 1;
				while ( true ) {
					if ( mat[Br][Bc+cnt] == '#' ) {
						mat[Br][Bc] = '.';
						Bc= Bc + cnt - 1;
						mat[Br][Bc] = 'B';
						break;
					}
					else if (  mat[Br][Bc+cnt] == 'O') {
						mat[Br][Bc] = '.';
						Bc = Bc + cnt;
						break;
					}
					cnt++;
				}
				
				cnt = 1;
				while ( true ) {
					if ( mat[Rr][Rc+cnt] == '#' || mat[Rr][Rc+cnt] == 'B'  ) {
						mat[Rr][Rc] = '.';
						Rc = Rc + cnt - 1;
						mat[Rr][Rc] = 'R';
						break;
					}
					else if (  mat[Rr][Rc+cnt] == 'O') {
						mat[Rr][Rc] = '.';
						Rc = Rc + cnt;
						break;
					}
					cnt++;
				}
			}else {
				
				int cnt = 1;
				while ( true ) {
					if ( mat[Rr][Rc+cnt] == '#'  ) {
						mat[Rr][Rc] = '.';
						Rc = Rc + cnt - 1;
						mat[Rr][Rc] = 'R';
						break;
					}
					else if (  mat[Rr][Rc+cnt] == 'O') {
						mat[Rr][Rc] = '.';
						Rr = Rr + cnt;
						break;
					}
					cnt++;
				}
				
				cnt = 1;
				while ( true ) {
					if ( mat[Br][Bc+cnt] == '#' || mat[Br][Bc+cnt] == 'R'  ) {
						mat[Br][Bc] = '.';
						Bc= Bc + cnt - 1;
						mat[Br][Bc] = 'B';
						break;
					}
					else if (  mat[Br][Bc+cnt] == 'O') {
						mat[Br][Bc] = '.';
						Bc = Bc + cnt;
						break;
					}
					cnt++;
				}
				
			}
		}else {
			
			int cnt = 1;
			while ( true ) {
				if ( mat[Rr][Rc+cnt] == '#' ) {
					mat[Rr][Rc] = '.';
					Rc = Rc + cnt - 1;
					mat[Rr][Rc] = 'R';
					break;
				}
				else if (  mat[Rr][Rc+cnt] == 'O') {
					mat[Rr][Rc] = '.';
					Rc = Rc + cnt;
					break;
				}
				cnt++;
			}
			
			cnt = 1;
			while ( true ) {
				if ( mat[Br][Bc+cnt] == '#' ) {
					mat[Br][Bc] = '.';
					Bc= Bc + cnt - 1;
					mat[Br][Bc] = 'B';
					break;
				}
				else if (  mat[Br][Bc+cnt] == 'O') {
					mat[Br][Bc] = '.';
					Bc = Bc + cnt;
					break;
				}
				cnt++;
			}
			
			
		}
		
		ArrayList<pack> list = new ArrayList<>();
		list.add(new pack(mat,Br,Bc,Rr,Rc));
		return list;
		
	}
	

}
