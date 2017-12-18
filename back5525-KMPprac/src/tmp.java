import java.util.*;

public class tmp {
	static ArrayList<Integer> location = new ArrayList<>();
	static int res=0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String L = in.nextLine();
		String pattern = in.nextLine();
		KMP(L,pattern);
		System.out.println(location.size());
		for ( int i = 0 ; i < location.size() ; i++) {
			System.out.print(location.get(i)+" ");
		}
	}
	
	public static void KMP(String L,String pattern) {
		char in[] = L.toCharArray();
		char pat[] = pattern.toCharArray();

		int fail[] = make(pattern);
		int i=0,j=0;
		for ( i=0,j=0; i< in.length ;i++) {
			while ( j>0 && in[i] != pat[j]) {
				j = fail[j-1];
			}
			if ( pat[j] == in[i]) {
				if ( j == pat.length-1) {
					//System.out.println(i);
					location.add(i-pat.length+2);
					j = fail[j];
				}else {
					j++;

				}
			}
		}
	}
	
	public static int[] make(String pattern) {
		char[] pat = pattern.toCharArray();
		int fail[] = new int[pat.length];
		
		int j = 0;
		for ( int i =1 ; i < pat.length ; i++) {
			while ( j>0 && pat[i] != pat[j] ) {
				j = fail[j-1];
			}
			if ( pat[i] == pat[j]) {
				fail[i] = ++j;
			}
		}
		
		return fail;
	}
}
