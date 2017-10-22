package back1373;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String a = in.next();
		int len = a.length();
		StringBuffer str;
		if(len % 3 == 1){
			str = new StringBuffer("00");
			str.append(a);
		}else if(len % 3 == 2){
			str = new StringBuffer("0");
			str.append(a);
		}else{
			str = new StringBuffer(a);
		}
		len = str.length();
		for(int i = 0; i < len ; i+= 3){
			int res = 0;
			if(str.charAt(i) == '1')
				res += 4;
			if(str.charAt(i+1)=='1')
				res += 2;
			if(str.charAt(i+2)=='1')
				res += 1;
			System.out.print(res);
		}
		System.out.println("");
	}
}
