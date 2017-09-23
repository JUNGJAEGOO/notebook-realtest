package back1075;
import java.util.*;
public class Main {

	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int F = in.nextInt();
		
		String a = Integer.toString(N);
		char tmp[] = a.toCharArray();
		tmp[tmp.length-1] = '0';
		tmp[tmp.length-2] = '0';
		String b = String.valueOf(tmp);
		int c = Integer.parseInt(b);
		
		int count = 0;
		int res;
		while ( count < 100 ) {
			int tmpc = c + count;
			//System.out.println("현재"+tmpc);
			if ( tmpc % F == 0 ) {
			
				//System.out.println(tmpc);
				
				String aAA = Integer.toString(tmpc);
				char tmpp[] = aAA.toCharArray();
				System.out.println(tmpp[tmpp.length-2]+""+tmpp[tmpp.length-1]);
				
				break;
				
			}
			
			count++;
		}
		
	}
}
