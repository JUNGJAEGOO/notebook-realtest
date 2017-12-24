package back3613;
import java.io.*;
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String sp[] = input.split("_");
		StringBuilder sb = new StringBuilder();
		boolean find = false;
		char[] check = input.toCharArray();
		int count = 0;
		boolean shit = false;
		while ( count < input.length() ) {
			if ( check[count] == '_' ) {
				find = true;
				if ( count == input.length()-1) {
					shit = true;
				}
			}
			count++;
		}
		//System.out.println((char)'z'+0);  // 대 65 97 소
		//System.out.println((char)'Z'+0);  // 대 90 122 소
		
		if ( find ) { // C로 입력 받았을 때.
			
			for ( int i = 0 ; i < sp.length ; i++) {
				
				String tmp = sp[i];
				//System.out.println(tmp);
				if ( tmp.equals("")) {
					shit = true;
					//System.out.println("empty");
					continue;
				}
				
				char[] tmpchar = tmp.toCharArray();
				for ( int k = 0 ; k  < tmp.length() ; k++) {
				if ( tmpchar[k] >= 'A' && tmpchar[k] <= 'Z') {
					shit = true;
				}
				}
				
				if ( i > 0 ) {
					
					tmpchar[0] = String.valueOf(tmpchar[0]).toUpperCase().charAt(0);
					String haha = "";
					for ( int j = 0 ; j < tmpchar.length ; j++) {
						
						haha+=tmpchar[j];
					}
					tmp = haha;
				}
				
				sb.append(tmp);
			}
		}else { // 자바로 입력 받았을 때.
			String first = "";
			char[] in = input.toCharArray();
			int cnt = 0;
			while ( cnt < input.length() ) {
				if ( (char)(in[cnt]+0) < 65 || (char)(in[cnt]+0) > 90) {
					first += in[cnt];

				}else {
					if ( cnt == 0) {
						shit = true;
					}
					first = first + "_" + (char)(in[cnt]+32);
				}
				cnt++;
			}

			//if ( first.length() != input.length()) {
				//System.out.print(first.length()+","+input.length());
				sb.append(first);
			//}
		}
		
		if ( shit) {
			sb = new StringBuilder();
		}
		if ( sb.length() == 0) {
			System.out.println("Error!");
		}else {
			System.out.println(sb);
		}
	}
}
