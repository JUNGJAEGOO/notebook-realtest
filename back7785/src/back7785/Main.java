package back7785;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
		StringTokenizer st;
		
		int N  = Integer.parseInt(br.readLine());
		
		Set<String> hm = new HashSet<>();
		
		String a = "";
		String b = "";
		String tmp = "";
		while ( N>0 ) {
			
			tmp = br.readLine();
			st = new StringTokenizer(tmp," ");
			a = st.nextToken();
			b = st.nextToken();
			if ( b.equals("leave")) {
				hm.remove(a);
			}else {
				hm.add(a);
			}
			N--;
		}
		
		String[] result = hm.toArray(new String[hm.size()]);
		Arrays.sort(result);
		for ( int i = result.length-1 ; i >= 0 ; i--) {
			bw.write(result[i]+"\n");
		}
		
		bw.flush();
	}
}
