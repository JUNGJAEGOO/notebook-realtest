package back11609;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		ArrayList<name> list = new ArrayList<>();
		for (int i = 0 ; i < T ; i++) {
			String full[] = in.nextLine().split(" ");
			list.add(new name(full[0],full[1]));
		}
		Collections.sort(list);
		for (int i = 0 ; i < T ; i++) {
			System.out.println(list.get(i).first+" "+list.get(i).last);
		}
	}
	
	public static class name implements Comparable<name>{
		String first;
		String last;
		name(String first,String last){
			this.first = first;
			this.last = last;
		}
		@Override
		public int compareTo(name o) {
			if ( this.first.compareTo(o.first) > 0) {
				return 1;
			}else if ( this.first.compareTo(o.first) == 0) {
				if ( this.last.compareTo(o.last) > 0) {
					return 1;
				}else {
					return -1;
				}
			}
			return -1;
		}
		
		
	}
}
