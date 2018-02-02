package back4158;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[])throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while ( true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if ( N == 0 && M == 0) {
				break;
			}
			HashMap<Integer,Integer> hm = new HashMap<>();
			for (int i = 0 ; i < N ; i++) {
				int x = Integer.parseInt(br.readLine());
				if ( hm.get(x) == null) {
					hm.put(x, 1);
				}else {
					hm.replace(x, hm.get(x)+1);
				}
			}
			int ans = 0;
			for (int i = 0 ; i < M ; i++) {
				int x = Integer.parseInt(br.readLine());
				if ( hm.get(x) == null) {
					hm.put(x, 1);
				}else {
					ans++;
					hm.replace(x, hm.get(x)+1);
				}
			}
			/*Iterator itr = hm.keySet().iterator();
			int ans = 0;
			while ( itr.hasNext() ) {
				int key = (int)itr.next();
				if ( hm.get(key) > 1) {
					ans++;
				}
			}*/
			
			sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
}
