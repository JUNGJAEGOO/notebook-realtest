package back2306;

import java.util.*;

public class Main {
	static String target;
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		target = in.nextLine();
		
		func("",0);
	}

	// a -- t 추가는 1
	// g -- c 추가는 2
	
	public static void func(String in,int len) {
		System.out.println(len+" "+in);
		if ( len > 10) {
			return;
		}else {
			if ( !list.contains("a"+in+"t") ) {
				list.add("a"+in+"t");
				func("a"+in+"t",len+2);
			}
			if ( !list.contains("g"+in+"c") ) {
				list.add("g"+in+"c");
				func("g"+in+"c",len+2);
			}
		}
		
	}
}
