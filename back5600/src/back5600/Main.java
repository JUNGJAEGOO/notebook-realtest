package back5600;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		int power[] = new int[a+1];
		int motor[] = new int[b+1];
		int cable[] = new int[c+1];
		Arrays.fill(power,2);
		Arrays.fill(motor,2);
		Arrays.fill(cable,2);
		
		int N = in.nextInt();
		ArrayList<node> list  = new ArrayList<>();
		
		for (int s = 0 ; s < N ; s++) {
			int i = in.nextInt();
			int j = in.nextInt();
			int k = in.nextInt();
			int state = in.nextInt();
			list.add(new node(i,j,k,state));
		}
		
		for (int num = 0 ; num < 1001 ; num++) {
			for (int s = 0 ; s < list.size() ; s++) {
				int i = list.get(s).i;
				int j = list.get(s).j;
				int k = list.get(s).k;
				int state = list.get(s).state;
				j -= a;
				k -= a+b;
				
				
				if ( state == 1) {
					
					power[i] = 1;
					motor[j] = 1;
					cable[k] = 1;
					
				}else {
				
					if ( power[i] == 1 && motor[j] == 1 && cable[k] == 2) {
						cable[k] = 0;
					}else if ( power[i] == 1 && motor[j] == 2 && cable[k] == 1) {
						motor[j] = 0;
					}else if ( power[i] == 2 && motor[j] == 1 && cable[k] == 1) {
						power[i] = 0;
					}
				
				}
			}
		}
		
		for (int i = 1 ; i<= a ; i++) {
			System.out.println(power[i]);
		}
		for (int i = 1 ; i<= b ; i++) {
			System.out.println(motor[i]);
		}
		for (int i = 1 ; i<= c ; i++) {
			System.out.println(cable[i]);
		}
		
	}
	
	public static class node{
		int i;
		int j;
		int k;
		int state;
		node (int i,int j,int k,int state){
			this.i = i;
			this.j = j;
			this.k = k;
			this.state = state;
		}
	}
}
