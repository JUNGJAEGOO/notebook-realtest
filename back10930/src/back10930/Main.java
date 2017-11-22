package back10930;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
public class Main {
	public static void main(String args[]) throws NoSuchAlgorithmException {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		MessageDigest md = MessageDigest.getInstance("sha-256");
		md.update(input.getBytes());
		byte[] b = md.digest();
		StringBuffer sb = new StringBuffer();
		for( int i = 0 ; i < b.length ; i++) {
			sb.append(Integer.toString((b[i]&0xff)+0x100,16).substring(1));
		}
		System.out.println(sb.toString());
	}
}
