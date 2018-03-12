package back14467;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		state cow[] = new state[11];
		for ( int i = 1 ; i < 11 ; i++) {
			cow[i] = new state(-1);
		}
		int sum = 0;
		for (int i = 0 ; i < N ; i++) {
			int id = in.nextInt();
			int state = in.nextInt();
			if ( cow[id].state == -1) {
				cow[id].state = state;
			}else if ( state == 0 && cow[id].state == 1) {
				cow[id].state = 0;
				sum++;
			}else if  ( state == 1 && cow[id].state == 1){
				
			}else if  ( state == 0 && cow[id].state == 0){
				
			}else if  ( state == 1 && cow[id].state == 0){
				sum++;
				cow[id].state = 1;
			}
		}
		System.out.println(sum);
	}
	
	public static class state{
		int state;
		state ( int state){
			this.state = state;
		}
	}
}
