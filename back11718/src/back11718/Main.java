package back11718;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		StringBuilder sb =new StringBuilder();
		while ( in.hasNext() ) {
			sb.append(in.nextLine()+"\n");
		}
		System.out.println(sb);
	}
}
