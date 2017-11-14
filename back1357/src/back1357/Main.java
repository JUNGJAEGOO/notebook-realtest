package back1357;
import java.util.*;
public class Main {
	public static void main  ( String args[]) {
		Scanner in = new Scanner ( System.in);
		String x = in.next();
		String y = in.next();
		char[] tmpcharx = x.toCharArray();
		char[] tmpchary = y.toCharArray();

		
		for ( int i = 0 ; i < (tmpcharx.length/2) ; i++) {
			char tmp = tmpcharx[i];
			tmpcharx[i] = tmpcharx[tmpcharx.length-i-1];
			tmpcharx[tmpcharx.length-i-1] = tmp;
		}
		
		for ( int i = 0 ; i < (tmpchary.length/2) ; i++) {
			char tmp = tmpchary[i];
			tmpchary[i] = tmpchary[tmpchary.length-i-1];
			tmpchary[tmpchary.length-i-1] = tmp;
		}
		
		int z = Integer.parseInt(String.valueOf(tmpcharx)) + Integer.parseInt(String.valueOf(tmpchary));
		String tmpz = Integer.toString(z);
		char[] tmpcharz = tmpz.toCharArray();
		
		for ( int i = 0 ; i < (tmpcharz.length/2) ; i++) {
			char tmp = tmpcharz[i];
			tmpcharz[i] = tmpcharz[tmpcharz.length-i-1];
			tmpcharz[tmpcharz.length-i-1] = tmp;
		}
		
		System.out.println(Integer.parseInt(String.valueOf(tmpcharz)));
		
	}
}
