package back1662;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner inner = new Scanner(System.in);
		String in = inner.nextLine();
		
		/*while ( true ) {
		 if (in.contains("()")) {
			in = in.replace("()","");
		 }else {
			 break;
		 }
		}*/
		
		//System.out.println(in);
		if ( in.equals("")) {
			System.out.println(0);
			return;
		}
		char[] input = in.toCharArray();
		
		int num = 0;
		for ( int i = 0 ; i < input.length ; i++) {
			if ( input[i] == '(') {
				num++;
			}
		}
		
		if ( num == 0) {
			System.out.println(in);
			return;
		}
		
		// 9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(9(111)))))))))))))))
		
		Stack<Character> st = new Stack<>();
		
		int cnt = 0;
		while ( input[cnt] != ')') {
			st.add(input[cnt]);
			cnt++;;
		}
		
		boolean first = true;
		while ( true ) {
			if(  num == 0 ) {
				break;
			}
			String tmp = "";
			boolean pass = false;
			String a= "";
			String b = "";
			if ( first == false ) {
			while ( true ) {
				char c = st.pop();
				if ( c == '(' ) {
					num--;
					a = rev(a);
					b = rev(b);
					//System.out.println(b);
					BigInteger haha = new BigInteger(b);
					//System.out.println("a is "+a+", b is "+haha);
					
					tmp = String.valueOf(haha.add(BigInteger.valueOf(a.length())));
					break;
				}else {
					if ( pass == false && c != '+') {
						b += c;
					}else {
						if ( c != '+') {
						a += c;
						}
					}
					if ( c == '+') {
						pass = true;
					}
					
				}
			}
			}else if ( first == true) {
				
				while ( true ) {
					char c = st.pop();
					if ( c == '(') {
						num--;
						break;
					}else {
						tmp += c;
					}
				}
				
			}
			
			//System.out.println(tmp);
			
			BigInteger len = BigInteger.valueOf(tmp.length());
			char banbok = st.pop();
			//System.out.println("banbok is "+banbok);
			if ( first == false) {
				len = new BigInteger(tmp);
			}
			//System.out.println("len is "+len);
			String insert = String.valueOf( len.multiply(BigInteger.valueOf(Integer.parseInt(String.valueOf(banbok))) ));
			//System.out.println("intsert is "+ insert);
			char[] ins = insert.toCharArray();
			
			first = false;
			st.add('+');
			for ( int i = 0 ; i < ins.length ; i++) {
				st.add(ins[i]);
			}
		}
		
		String res ="";
		while ( !st.isEmpty() ) {
			res += st.pop();
		}
		res = rev(res);
		//System.out.println(res);
		
		char[] result = res.toCharArray();
		
		String A = "";
		String B = "";
		
		boolean passing = false;
		for ( int i = 0 ; i < result.length ; i++) {
			if ( passing == true) {
				B += result[i];
				continue;
			}
			
			if ( result[i] == '+') {
				passing = true;
			}else if ( passing == false) {
				A += result[i];
			}
		}
		
		//System.out.println(A+"+"+B);
		System.out.println(new BigInteger(B).add(BigInteger.valueOf(A.length())));
		
		
	}
	
	public static String rev(String a) {
		char tmp[] = a.toCharArray();
		String ans = "";
		for ( int i = tmp.length-1 ; i >= 0 ; i--) {
			ans += tmp[i];
		}
		
		return ans;
	}
}
