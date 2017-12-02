package back2602;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Mainb {
	static char devil[];
	static char angel[];
	static char quest[];
	static int result = 0;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		quest = br.readLine().toCharArray();
		devil = br.readLine().toCharArray();
		angel = br.readLine().toCharArray();
		
		
		BFS();
		System.out.println(result);
		
	}
	
	public static void BFS() {
		Queue<data> q = new LinkedList<>();
		int qcount = 0;
		
		
		
		for ( int i = 0 ; i < devil.length ; i++) {
			if ( quest[qcount] == devil[i] ) {
				q.add(new data("devil",0,i));
			}
		}
		for ( int i = 0 ; i < angel.length ; i++) {
			if ( quest[qcount] == angel[i] ) {
				q.add(new data("angel",0,i));
			}
		}
		
		while ( !q.isEmpty() ) {
			data tmp = q.poll();
			int idx = tmp.idx;
			int count = tmp.count;
			if ( tmp.count == quest.length-1) {
				result++;
				continue;
			}
			
			if ( tmp.count + 1 > quest.length-1) {
				continue;
			}
			
			
			if ( tmp.sex.equals("angel")) {
				//System.out.println(tmp.count+" "+angel[tmp.idx]);
				for ( int i = idx+1 ; i < devil.length ; i++) {
					if ( quest[count+1] == devil[i] ) {
						q.add(new data("devil",count+1,i));
					}
				}
			}
			if ( tmp.sex.equals("devil")) {
				//System.out.println(tmp.count+" "+devil[tmp.idx]);
				for ( int i = idx+1 ; i < angel.length ; i++) {
					if ( quest[count+1] == angel[i] ) {
						q.add(new data("angel",count+1,i));
					}
				}
			
			}
			
		}
	}
	
	
	public static class data{
		String sex;
		int count;
		int idx;
		data(String sex,int count,int idx){
			this.sex = sex;
			this.count = count;
			this.idx = idx;
		}
		
	}
}
