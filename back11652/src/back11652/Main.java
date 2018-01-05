package back11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Integer> hm  =new HashMap<String,Integer>();
		for ( int i = 0 ; i < N ; i++) {
			String number = br.readLine();
			if ( hm.get(number) == null) {
				hm.put(number,1);
			}else {
				int K = hm.get(number);
				hm.replace(number, (K+1));
			}
		}
		
		long max = 0;
		long maxidx = 0;
		
		ArrayList<Long> Same = new ArrayList<>();
		Iterator it = hm.keySet().iterator();
		
		while ( it.hasNext() ) {
			String key = (String) it.next();
			long tmp = hm.get(key);
			
			if ( tmp > max) {
				max = tmp;
				maxidx = Long.parseLong(key);
				Same = new ArrayList<>();
				Same.add(maxidx);
			}else if ( tmp == max) {
				Same.add(Long.parseLong(key));
			}
		}
		
		Collections.sort(Same);
		System.out.println(String.valueOf(Same.get(0)));
	}
}
