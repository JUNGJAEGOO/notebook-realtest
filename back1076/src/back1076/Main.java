package back1076;
import java.util.*;
public class Main {

	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		String first = in.nextLine();
		String second = in.nextLine();
		String third = in.nextLine();
		int firstnum = 0;
		int secondnum = 0;
		String thirdnum = null;
		
		
		if (first.equals("black")) {
			firstnum = 0;
		}
		else if(first.equals("brown")) {
			firstnum = 1;
		}
		else if(first.equals("red")) {
			firstnum = 2;
		}
		else if(first.equals("orange")) {
			firstnum = 3;
		}
		else if(first.equals("yellow")) {
			firstnum = 4;
		}
		else if(first.equals("green")) {
			firstnum = 5;
		}
		else if(first.equals("blue")) {
			firstnum = 6;
		}
		else if(first.equals("violet")) {
			firstnum = 7;
		}
		else if(first.equals("grey")) {
			firstnum = 8;
		}
		else if(first.equals("white")) {
			firstnum = 9;
		}
		
		if (second.equals("black")) {
			secondnum = 0;
		}
		else if(second.equals("brown")) {
			secondnum = 1;
		}
		else if(second.equals("red")) {
			secondnum = 2;
		}
		else if(second.equals("orange")) {
			secondnum = 3;
		}
		else if(second.equals("yellow")) {
			secondnum = 4;
		}
		else if(second.equals("green")) {
			secondnum = 5;
		}
		else if(second.equals("blue")) {
			secondnum = 6;
		}
		else if(second.equals("violet")) {
			secondnum = 7;
		}
		else if(second.equals("grey")) {
			secondnum = 8;
		}
		else if(second.equals("white")) {
			secondnum = 9;
		}
		
		if (third.equals("black")) {
			thirdnum = "";
		}
		else if(third.equals("brown")) {
			thirdnum = "0";
		}
		else if(third.equals("red")) {
			thirdnum = "00";
		}
		else if(third.equals("orange")) {
			thirdnum = "000";
		}
		else if(third.equals("yellow")) {
			thirdnum = "0000";
		}
		else if(third.equals("green")) {
			thirdnum = "00000";
		}
		else if(third.equals("blue")) {
			thirdnum = "000000";
		}
		else if(third.equals("violet")) {
			thirdnum = "0000000";
		}
		else if(third.equals("grey")) {
			thirdnum = "00000000";
		}
		else if(third.equals("white")) {
			thirdnum = "000000000";
		}
		
		
		int sootza = firstnum*10 + secondnum;
		String soo = Integer.toString(sootza);
		
		String result = soo+thirdnum;
		if (sootza == 0) {
			System.out.println(0);
		}
		else {
		System.out.println(result);
		}
	}
}
