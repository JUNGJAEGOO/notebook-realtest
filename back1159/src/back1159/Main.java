package back1159;

import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//char a = 'a';
		//System.out.println(a+1);
		int alpha[] = new int[26];
		for (int i = 0 ; i < N ; i++) {
			String input = br.readLine();
			if ( input.charAt(0) == 'a') {
				alpha[0]++;
			}else if ( input.charAt(0) == 'b') {
				alpha[1]++;
			}else if ( input.charAt(0) == 'c') {
				alpha[2]++;
			}else if ( input.charAt(0) == 'd') {
				alpha[3]++;
			}else if ( input.charAt(0) == 'e') {
				alpha[4]++;
			}else if ( input.charAt(0) == 'f') {
				alpha[5]++;
			}else if ( input.charAt(0) == 'g') {
				alpha[6]++;
			}else if ( input.charAt(0) == 'h') {
				alpha[7]++;
			}else if ( input.charAt(0) == 'i') {
				alpha[8]++;
			}else if ( input.charAt(0) == 'j') {
				alpha[9]++;
			}else if ( input.charAt(0) == 'k') {
				alpha[10]++;
			}else if ( input.charAt(0) == 'l') {
				alpha[11]++;
			}else if ( input.charAt(0) == 'm') {
				alpha[12]++;
			}else if ( input.charAt(0) == 'n') {
				alpha[13]++;
			}else if ( input.charAt(0) == 'o') {
				alpha[14]++;
			}else if ( input.charAt(0) == 'p') {
				alpha[15]++;
			}else if ( input.charAt(0) == 'q') {
				alpha[16]++;
			}else if ( input.charAt(0) == 'r') {
				alpha[17]++;
			}else if ( input.charAt(0) == 's') {
				alpha[18]++;
			}else if ( input.charAt(0) == 't') {
				alpha[19]++;
			}else if ( input.charAt(0) == 'u') {
				alpha[20]++;
			}else if ( input.charAt(0) == 'v') {
				alpha[21]++;
			}else if ( input.charAt(0) == 'w') {
				alpha[22]++;
			}else if ( input.charAt(0) == 'x') {
				alpha[23]++;
			}else if ( input.charAt(0) == 'y') {
				alpha[24]++;
			}else if ( input.charAt(0) == 'z') {
				alpha[25]++;
			}

		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < 26 ; i++) {
			if ( alpha[i] >= 5) {
				char tmp = (char) (i + 97);
				sb.append(String.valueOf(( tmp )));
			}
		}
		if ( sb.length() == 0) {
			System.out.println("PREDAJA");
		}else {
		System.out.println(sb);
		}
	}
}
